package cn.skill6.website.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Skill6AuthenticationFilter extends FormAuthenticationFilter {

  private static final String AUTH_CODE_PARAM = "code";

  public static final String REFERER_URI_KEY = "refererUrl";

  private boolean thirdPartyAuth = false;

  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws Exception {
    if (!isLoginRequest(request, response)) {
      log.info(
          "Attempting to access a path which requires authentication.  Forwarding to the "
              + "Authentication url ["
              + getLoginUrl()
              + "]");

      saveRequestAndRedirectToLogin(request, response);
      return false;
    }

    // 自定义登录为post登录
    if (isLoginSubmission(request, response)) {
      log.trace("Login submission detected.  Attempting to execute login.");
      return executeLogin(request, response);
    }

    log.trace("Login page view.");
    // allow them to see the login page ;)
    return true;
  }

  /** 判断是否是登录提交 */
  @Override
  protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
    return (request instanceof HttpServletRequest)
        && (WebUtils.toHttp(request).getMethod().equalsIgnoreCase(POST_METHOD)
            || WebUtils.toHttp(request).getMethod().equalsIgnoreCase(GET_METHOD));
  }

  /** 重写创建token,加入登录类型枚举 */
  @Override
  protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
    boolean rememberMe = isRememberMe(request);
    String host = getHost(request);
    String authCode = getAuthCode(request);
    String requestURI = getPathWithinApplication(request);

    if (StringUtils.equals(requestURI, LoginType.GITHUB.getUri())) {
      return new AccountPasswordTypeToken(rememberMe, host, LoginType.GITHUB, authCode);
    }
    if (StringUtils.equals(requestURI, LoginType.QQ.getUri())) {
      return new AccountPasswordTypeToken(rememberMe, host, LoginType.QQ, authCode);
    }

    thirdPartyAuth = true;
    String username = getUsername(request);
    String password = getPassword(request);

    return new AccountPasswordTypeToken(username, password, rememberMe, host, LoginType.USERNAME);
  }

  /** 根据登录类型分别重定向 */
  @Override
  protected void issueSuccessRedirect(ServletRequest request, ServletResponse response)
      throws Exception {
    if (!thirdPartyAuth) {
      super.issueSuccessRedirect(request, response);
      return;
    }

    Session session = SecurityUtils.getSubject().getSession();
    String successUrl = (String) session.getAttribute(REFERER_URI_KEY);
    log.info("last resquest url: {}", successUrl);

    if (StringUtils.isEmpty(successUrl)) {
      successUrl = getSuccessUrl();
    }

    WebUtils.issueRedirect(request, response, successUrl, null, true);
  }

  protected String getAuthCode(ServletRequest request) {
    return WebUtils.getCleanParam(request, AUTH_CODE_PARAM);
  }
}
