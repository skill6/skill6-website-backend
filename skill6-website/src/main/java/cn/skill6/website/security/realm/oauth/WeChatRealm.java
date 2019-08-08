package cn.skill6.website.security.realm.oauth;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.website.security.realm.Skill6Realm;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Repository;

/**
 * 微信登录域
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 上午1:10:49
 */
@Slf4j
@Repository
public class WeChatRealm extends Skill6Realm {

    /**
     * 仅支持微信方式登录
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        log.debug("access UserNameRealm.supports()");
        AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;

        return LoginType.WECHAT == typeToken.getLoginType();
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

        return;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        return null;
    }
}
