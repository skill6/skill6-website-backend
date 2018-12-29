package cn.skill6.website.controller.sign;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.skill6.common.controller.BaseController;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.microservice.sign.SignInSvc;
import lombok.extern.slf4j.Slf4j;

/**
 * 登录控制器
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月23日 下午10:09:15
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class ThirdAuthController extends BaseController {

  private static final String refererUriKey = "refererUrl";

  @Autowired private SignInSvc signSvc;

  @GetMapping(value = "/github")
  public void loginByGitHub() throws ServletException, IOException {
    response.sendRedirect("https://www.baidu.com");
  }

  @GetMapping(value = "/github/callback")
  public void loginByGitHubCallback(@RequestParam("code") String authCode)
      throws ServletException, IOException {
    signSvc.loginByGitHub(authCode);

    redirectToLastPage();
  }

  @GetMapping(value = "/qq")
  public String loginByQq() throws ServletException, IOException {
    if (!securityChainCheck()) {
      return "redirect:/error";
    }
    saveRefererPage();

    String clientId = "101536093";
    String redirectUri = "http://127.0.0.1:8081/login/qq/callback";

    String qqAuthUrl =
        new StringBuilder("redirect:")
            .append("https://graph.qq.com/oauth2.0/authorize")
            .append("?response_type=code")
            .append("&client_id=")
            .append(clientId)
            .append("&redirect_uri=")
            .append(redirectUri)
            .append("&state=1&scope=get_user_info,do_like")
            .toString();

    return qqAuthUrl;
  }

  @GetMapping(value = "/qq/callback")
  public void loginByQqCallback(@RequestParam("code") String authCode)
      throws ServletException, IOException {
    signSvc.loginByQq(authCode);

    redirectToLastPage();
  }

  /**
   * 防盗链检查
   *
   * @return 防盗链检查结果
   */
  private boolean securityChainCheck() throws IOException {
    // 获取请求来源地址
    String refererUrl = request.getHeader("referer");
    if (refererUrl == null
        || !refererUrl.startsWith("http://localhost")
        || !refererUrl.startsWith("http://skill6")
        || !refererUrl.startsWith("https://skill6")) {

      return false;
    }

    return true;
  }

  /** 保存请求源地址URL */
  private void saveRefererPage() throws IOException {
    String refererUrl = request.getHeader("referer");
    String requestContext = RequestParser.parseContextIndex(request).toString();
    String refererUri = refererUrl.replaceFirst(requestContext, "");

    Session session = SecurityUtils.getSubject().getSession();
    session.setAttribute(refererUriKey, refererUri);
  }

  /** 重定向到登录之前的页面 */
  private void redirectToLastPage() throws IOException {
    Session session = SecurityUtils.getSubject().getSession();
    String uri = (String) session.getAttribute(refererUriKey);
    log.info("last resquest url: {}", uri);

    if (StringUtils.isEmpty(uri)) {
      response.sendRedirect("/");
      return;
    }

    response.sendRedirect(uri);
  }
}
