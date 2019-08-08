package cn.skill6.website.security.token;

import cn.skill6.common.entity.enums.LoginType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义token:账户+密码+登录类型+授权码(可选)
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年10月23日 上午12:13:54
 */
@ToString(callSuper = true)
@NoArgsConstructor
public class AccountPasswordTypeToken extends UsernamePasswordToken {

    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private LoginType loginType;

    /**
     * 第三方授权的授权码
     */
    @Setter
    @Getter
    private String authCode;

    public AccountPasswordTypeToken(String authCode, LoginType loginType) {
        super();
        this.authCode = authCode;
        this.loginType = loginType;
    }

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

    public AccountPasswordTypeToken(
            String account, String password, LoginType loginType, String authCode) {
        super(account, password);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username,
            char[] password,
            boolean rememberMe,
            String host,
            LoginType loginType,
            String authCode) {
        super(username, password, rememberMe, host);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username, char[] password, boolean rememberMe, LoginType loginType, String authCode) {
        super(username, password, rememberMe);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username, char[] password, String host, LoginType loginType, String authCode) {
        super(username, password, host);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username, char[] password, LoginType loginType, String authCode) {
        super(username, password);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username,
            String password,
            boolean rememberMe,
            String host,
            LoginType loginType,
            String authCode) {
        super(username, password, rememberMe, host);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username, String password, boolean rememberMe, LoginType loginType, String authCode) {
        super(username, password, rememberMe);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            String username, String password, String host, LoginType loginType, String authCode) {
        super(username, password, host);
        this.loginType = loginType;
        this.authCode = authCode;
    }

    public AccountPasswordTypeToken(
            boolean rememberMe, String host, LoginType loginType, String authCode) {
        super(null, new String(), rememberMe, host);
        this.loginType = loginType;
        this.authCode = authCode;
    }
}
