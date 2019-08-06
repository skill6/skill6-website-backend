package cn.skill6.website.security.realm.oauth;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.common.transform.ConvertRequestParams;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.common.utility.HttpsClient;
import cn.skill6.microservice.basic.uesr.UserSvc;
import cn.skill6.website.config.Skill6Properties;
import cn.skill6.website.dao.intf.thirdparty.ThirdpartyAuthDao;
import cn.skill6.website.security.realm.Skill6Realm;
import cn.skill6.website.security.realm.oauth.constant.UrlRequest;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * github登录域
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年10月24日 上午12:24:25
 */
@Slf4j
@Repository
public class GitHubRealm extends Skill6Realm {

    @Autowired
    Skill6Properties skill6Properties;

    @Autowired
    private ThirdpartyAuthDao thirdpartyAuthDao;

    @Autowired
    private UserSvc userSvc;

    /**
     * 仅支持github方式登录
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        log.debug("access UserNameRealm.supports()");
        AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;

        return LoginType.GITHUB == typeToken.getLoginType();
    }

    /**
     * 第三方登录直接return表示通过,不参与后续doCredentialsMatch匹配
     *
     * @param authcToken 用户输入的token
     * @param info       数据库用户信息
     */
    @Override
    protected void assertCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info)
            throws AuthenticationException {
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        // 1.根据code获取access_token
        AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;
        String authCode = typeToken.getAuthCode();
        Skill6Properties.GitHub gitHub = skill6Properties.getGitHub();

        Map<String, String> params = new HashMap<String, String>(3);

        params.put(UrlRequest.PARAM_CLIENT_ID, gitHub.getClientId());
        params.put(UrlRequest.PARAM_CLIENT_SECRET, gitHub.getClientSecret());
        params.put(UrlRequest.PARAM_CODE, authCode);

        String response = HttpsClient.doPost(UrlRequest.GITHUB_GET_TOKEN, params);
        log.info("get access_token finished, response: {}", response);

        String accessToken = null;
        if (StringUtils.isNotEmpty(response)) {
            Map<String, String> map = ConvertRequestParams.paramsStr2Map(response);
            accessToken = map.get(UrlRequest.PARAM_ACCESS_TOKEN);
        }

        // 2.根据token获取用户信息
        params.clear();
        params.put(UrlRequest.PARAM_ACCESS_TOKEN, accessToken);
        response = HttpsClient.doGet(UrlRequest.GITHUB_GET_USER_INFO, params);
        log.info("get user_info finished, response: {}", response);

        Map<String, Object> responseMap;
        try {
            responseMap = JacksonUtil.str2Map(response);
        } catch (IOException e) {
            log.warn(StackTrace2Str.exceptionStackTrace2Str("解析json失败", e));
            return null;
        }

        // 3.查询账户是否绑定
        Object githubIdObj = responseMap.get(UrlRequest.PRIMARY_KEY_GITHUB);
        String githubId = String.valueOf(githubIdObj);
        ThirdpartyAuth thirdpartyAuth = new ThirdpartyAuth();
        thirdpartyAuth.setThirdpartyPrimaryKey(githubId);
        thirdpartyAuth.setThirdpartyValid(true);

        List<ThirdpartyAuth> thirdpartyAuths = thirdpartyAuthDao.findByParams(thirdpartyAuth);
        // 3.1 如果不为空，数量为肯定为1,设置当前为无效，并重新绑定
        if (CollectionUtils.isNotEmpty(thirdpartyAuths)) {
            log.info("unbind last all github auth record");
            thirdpartyAuth = thirdpartyAuths.get(0);
            thirdpartyAuth.setThirdpartyValid(false);
            thirdpartyAuthDao.updateByThirdpartyId(thirdpartyAuth);
        }

        // 3.2 不管是否为空，都要新建记录
        thirdpartyAuth.setThirdpartyValid(true);
        thirdpartyAuth.setThirdpartyCreateTime(new Date());
        thirdpartyAuth.setThirdpartyData(response);
        thirdpartyAuth.setThirdpartyId(SequenceManager.getNextId());

        if (thirdpartyAuth.getUserId() == null) {
            UserPrivacyInfo userPrivacyInfo = new UserPrivacyInfo();
            userPrivacyInfo.setUserLoginFrom("3");

            Long userId = userSvc.quickCreateUser(userPrivacyInfo);
            thirdpartyAuth.setUserId(userId);
        }

        thirdpartyAuthDao.addThirdpartyAuth(thirdpartyAuth);

        return buildAuthenticationInfo(thirdpartyAuth.getUserId(), getName());
    }
}
