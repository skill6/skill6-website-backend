package cn.skill6.website.security.realm.oauth;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;
import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.common.transform.ConvertRequestParams;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.common.utility.HttpsClient;
import cn.skill6.website.config.Skill6PropertyConfig;
import cn.skill6.website.dao.intf.thirdparty.ThirdpartyAuthDao;
import cn.skill6.website.security.realm.Skill6Realm;
import cn.skill6.website.security.realm.oauth.constant.UrlRequest;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import cn.skill6.website.sign.SignUpSvc;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * QQ登录域
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年11月1日 上午1:11:11
 */
@Slf4j
@Repository
public class QQRealm extends Skill6Realm {

    @Autowired
    private Skill6PropertyConfig skill6PropertyConfig;

    @Autowired
    private ThirdpartyAuthDao thirdpartyAuthDao;

    @Autowired
    private SignUpSvc signUpSvc;

    /**
     * 仅支持qq方式登录
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        log.debug("access UserNameRealm.supports()");
        AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;

        return LoginType.QQ == typeToken.getLoginType();
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
        Skill6PropertyConfig.QQ qq = skill6PropertyConfig.getQq();

        Map<String, String> params = new HashMap<>(3);

        params.put(UrlRequest.PARAM_CODE, authCode);
        params.put(UrlRequest.PARAM_GRANT_TYPE, UrlRequest.VALUE_GRANT_TYPE);
        params.put(UrlRequest.PARAM_CLIENT_ID, qq.getClientId());
        params.put(UrlRequest.PARAM_CLIENT_SECRET, qq.getClientSecret());
        params.put(UrlRequest.PARAM_REDIRECT_URI, qq.getRedirectUri());

        String response = HttpsClient.doGet(UrlRequest.QQ_GET_TOKEN, params);
        log.info("get access_token finished, response: {}", response);

        Map<String, String> map = ConvertRequestParams.paramsStr2Map(response);
        String accessToken = map.get(UrlRequest.PARAM_ACCESS_TOKEN);

        // 2.根据access_token获取openid
        params.clear();
        params.put(UrlRequest.PARAM_ACCESS_TOKEN, accessToken);
        response = HttpsClient.doGet(UrlRequest.QQ_GET_OPENID, params);
        log.info("get openid finished, response: {}", response);

        response = matchParentheses(response);
        if (StringUtils.isEmpty(response)) {
            log.error("match parentheses fail");
            return null;
        }

        map = JacksonUtil.str2Map(response);
        String openid = map.get(UrlRequest.PARAM_OPENID);

        // 3.获取用户信息
        params.clear();
        params.put(UrlRequest.PARAM_ACCESS_TOKEN, accessToken);
        params.put(UrlRequest.PARAM_OAUTH_CONSUMER_KEY, qq.getClientId());
        params.put(UrlRequest.PARAM_OPENID, openid);

        response = HttpsClient.doGet(UrlRequest.QQ_GET_USER_INFO, params);
        log.info("get user_info finished, response: {}", response);

        // 4.查询是否绑定
        ThirdpartyAuth thirdpartyAuth = new ThirdpartyAuth();
        thirdpartyAuth.setThirdpartyPrimaryKey(openid);
        thirdpartyAuth.setThirdpartyValid(true);

        List<ThirdpartyAuth> thirdpartyAuths = thirdpartyAuthDao.findByParams(thirdpartyAuth);
        // 3.1 如果不为空，数量为肯定为1,设置当前为无效，并重新绑定
        if (CollectionUtils.isNotEmpty(thirdpartyAuths)) {
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
            UserInfo userInfo = new UserInfo();
            userInfo.setUserLoginFrom("3");

            long userId = signUpSvc.quickCreateUser(userInfo);
            thirdpartyAuth.setUserId(userId);
        }

        thirdpartyAuthDao.addThirdpartyAuth(thirdpartyAuth);

        return buildAuthenticationInfo(thirdpartyAuth.getUserId(), getName());
    }

    /**
     * 正则匹配返回字符串括号里的json
     *
     * @param aimStr
     * @return
     */
    private String matchParentheses(String aimStr) {
        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
        Matcher matcher = pattern.matcher(aimStr);
        if (matcher.find()) {
            return matcher.group().trim();
        }

        return null;
    }
}
