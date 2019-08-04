package cn.skill6.website.security.realm.oauth.constant;

/**
 * 三方授权的URL常量
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月20日 下午11:37:33
 */
public class UrlRequest {
    public static final String GITHUB_GET_TOKEN = "https://github.com/login/oauth/access_token";
    public static final String GITHUB_GET_USER_INFO = "https://api.github.com/user";

    public static final String QQ_GET_TOKEN = "https://graph.qq.com/oauth2.0/token";
    public static final String QQ_REFRESH_TOKEN = QQ_GET_TOKEN;
    public static final String QQ_GET_OPENID = "https://graph.qq.com/oauth2.0/me";
    public static final String QQ_GET_USER_INFO = "https://graph.qq.com/user/get_user_info";

    public static final String PARAM_CLIENT_ID = "client_id";
    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String PARAM_CODE = "code";
    public static final String PARAM_ACCESS_TOKEN = "access_token";
    public static final String PARAM_GRANT_TYPE = "grant_type";
    public static final String PARAM_REFRESH_TOKEN = "refresh_token";
    public static final String PARAM_OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String PARAM_OPENID = "openid";
    public static final String PARAM_REDIRECT_URI = "redirect_uri";

    public static final String VALUE_GRANT_TYPE = "authorization_code";

    public static final String PRIMARY_KEY_GITHUB = "id";
    public static final String PRIMARY_KEY_QQ = PARAM_OPENID;
}
