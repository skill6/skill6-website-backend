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
  public void loginByGitHubCallback(@RequestParam("code") String authCode)
      throws ServletException, IOException {
    signSvc.loginByGitHub(authCode);

    redirectToLastPage();
  }

  @GetMapping(value = "/qq")
  public void loginByQqCallback(@RequestParam("code") String authCode)
      throws ServletException, IOException {
    signSvc.loginByQq(authCode);

    redirectToLastPage();
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
