package cn.skill6.website.controller.sign;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.skill6.common.controller.BaseController;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.website.config.Skill6Properties;
import lombok.extern.slf4j.Slf4j;

/**
 * 第三方授权连接控制器
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年12月30日 下午9:59:06
 */
@Slf4j
@Controller
@RequestMapping("/connect")
public class ThirdConnectController extends BaseController {

  private static final String refererUriKey = "refererUrl";

  @Autowired private Skill6Properties skill6Properties;

  @GetMapping(value = "/github")
  public String loginByGitHub() throws ServletException, IOException {
    Skill6Properties.GitHub github = skill6Properties.getGitHub();

    String githubAuthUrl =
        new StringBuilder()
            .append("redirect:")
            .append("https://github.com/login/oauth/authorize")
            .append("?client_id=")
            .append(github.getClientId())
            .append("&redirect_uri=")
            .append(github.getRedirectUri())
            .toString();

    return githubAuthUrl;
  }

  @GetMapping(value = "/qq")
  public String loginByQq() throws ServletException, IOException {
    if (!securityChainCheck()) {
      log.warn("security chain check fail");
      return "redirect:/error";
    }
    saveRefererPage();

    Skill6Properties.QQ qq = skill6Properties.getQq();

    // TODO - 加入display参数，手机端为mobile

    String qqAuthUrl =
        new StringBuilder("redirect:")
            .append("https://graph.qq.com/oauth2.0/authorize")
            .append("?response_type=code")
            .append("&client_id=")
            .append(qq.getClientId())
            .append("&redirect_uri=")
            .append(qq.getRedirectUri())
            .append("&state=")
            .append(qq.getState())
            .append("&scope=")
            .append(qq.getScope())
            .toString();

    return qqAuthUrl;
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
}
