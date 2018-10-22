package cn.skill6.website.security.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import cn.skill6.common.entity.enums.LoginType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 自定义token:账户+密码+登录类型
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月23日 上午12:13:54
 */
@ToString(callSuper = true)
@NoArgsConstructor
public class AccountPasswordTypeToken extends UsernamePasswordToken {

  private static final long serialVersionUID = 1L;

  @Setter @Getter private LoginType loginType;

  public AccountPasswordTypeToken(String account, String password, LoginType loginType) {
    super(account, password);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(
      String username, char[] password, boolean rememberMe, String host, LoginType loginType) {
    super(username, password, rememberMe, host);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(
      String username, char[] password, boolean rememberMe, LoginType loginType) {
    super(username, password, rememberMe);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(
      String username, char[] password, String host, LoginType loginType) {
    super(username, password, host);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(String username, char[] password, LoginType loginType) {
    super(username, password);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(
      String username, String password, boolean rememberMe, String host, LoginType loginType) {
    super(username, password, rememberMe, host);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(
      String username, String password, boolean rememberMe, LoginType loginType) {
    super(username, password, rememberMe);
    this.loginType = loginType;
  }

  public AccountPasswordTypeToken(
      String username, String password, String host, LoginType loginType) {
    super(username, password, host);
    this.loginType = loginType;
  }
}
