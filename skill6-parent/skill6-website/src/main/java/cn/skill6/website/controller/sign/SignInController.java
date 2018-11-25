package cn.skill6.website.controller.sign;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
public class SignInController extends BaseController {

  @Autowired private SignInSvc signSvc;

  @PostMapping(value = "/github")
  public void loginByGitHub(@RequestParam("code") String authCode)
      throws ServletException, IOException {
    signSvc.loginByGitHub(authCode);

    redirectToLastPage();
  }

  @PostMapping(value = "/qq")
  public void loginByQq(@RequestParam("code") String authCode)
      throws ServletException, IOException {
    signSvc.loginByGitQq(authCode);

    redirectToLastPage();
  }

  private void redirectToLastPage() throws ServletException, IOException {
    SavedRequest req = WebUtils.getSavedRequest(request);
    String url = req.getRequestURI();
    log.info("last resquest url: {}", url);

    url = url.substring(url.lastIndexOf('/'));
    log.info("redirect resquest url: {}", url);
   
    request.getRequestDispatcher(url).forward(request, response);
  }
}
