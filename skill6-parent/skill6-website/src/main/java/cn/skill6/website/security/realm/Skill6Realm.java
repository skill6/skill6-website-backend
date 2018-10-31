package cn.skill6.website.security.realm;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义域基类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 上午1:24:10
 */
public abstract class Skill6Realm extends AuthorizingRealm {

  @Autowired CredentialsMatcher credentialsMatcher;

  public Skill6Realm() {
    this.setCredentialsMatcher(credentialsMatcher);
    this.setCachingEnabled(true);
    this.setAuthenticationCachingEnabled(true);
    this.setAuthenticationCacheName("authenticationCache");
    this.setAuthorizationCachingEnabled(true);
    this.setAuthorizationCacheName("authorizationCache");
  }
}
