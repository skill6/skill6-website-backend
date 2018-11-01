package cn.skill6.website.security.realm.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Repository;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.website.security.realm.Skill6Realm;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import lombok.extern.slf4j.Slf4j;

/**
 * 手机验证码登录
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 上午1:15:05
 */
@Slf4j
@Repository
public class PhoneRealm extends Skill6Realm {

  /** 仅支持手机方式登录 */
  @Override
  public boolean supports(AuthenticationToken token) {
    log.debug("access UserNameRealm.supports()");
    AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;

    return LoginType.PHONE == typeToken.getLoginType();
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    // TODO - 完善
    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    // TODO - 完善
    return null;
  }
}
