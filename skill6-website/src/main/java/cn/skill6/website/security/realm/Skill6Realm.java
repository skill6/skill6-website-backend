package cn.skill6.website.security.realm;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * 自定义域基类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 上午1:24:10
 */
public abstract class Skill6Realm extends AuthorizingRealm {

    public Skill6Realm() {
        super.setCachingEnabled(true);

        super.setAuthenticationCachingEnabled(true);
        super.setAuthenticationCacheName("authenticationCache");

        super.setAuthorizationCachingEnabled(true);
        super.setAuthorizationCacheName("authorizationCache");
    }

    /**
     * 第三方授权包装没有密码的认证信息
     *
     * @param principal 用户id
     * @param realmName realm名称
     * @return 认证信息
     */
    protected SimpleAuthenticationInfo buildAuthenticationInfo(Object principal, String realmName) {
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        PrincipalCollection principals = new SimplePrincipalCollection(principal, realmName);
        authenticationInfo.setPrincipals(principals);

        return authenticationInfo;
    }
}
