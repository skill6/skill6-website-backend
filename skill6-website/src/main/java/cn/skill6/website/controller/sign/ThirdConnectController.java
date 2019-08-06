package cn.skill6.website.controller.sign;

import cn.skill6.common.constant.UserAgentType;
import cn.skill6.common.controller.BaseController;
import cn.skill6.common.utility.JudgeIsMobile;
import cn.skill6.website.config.Skill6Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;

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

    @Autowired
    private Skill6Properties skill6Properties;

    @GetMapping(value = "/github")
    public String connectByGitHub() throws ServletException, IOException {
        if (!isSecurityChain()) {
            ThirdConnectController.log.warn("security chain check fail");
            return "redirect:/error";
        }

        Skill6Properties.GitHub github = skill6Properties.getGitHub();

        String githubAuthUrl = "redirect:" + "https://github.com/login/oauth/authorize" +
                "?client_id=" + github.getClientId() +
                "&redirect_uri=" + github.getRedirectUri();

        log.info("github auth url: {}", githubAuthUrl);

        return githubAuthUrl;
    }

    @GetMapping(value = "/qq")
    public String connectByQq() {
        if (!isSecurityChain()) {
            ThirdConnectController.log.warn("security chain check fail");
            return "redirect:/error";
        }

        Skill6Properties.QQ qq = skill6Properties.getQq();

        String display = UserAgentType.PC.getUserAgent();
        if (JudgeIsMobile.isMobile(request.getHeader("user-agent"))) {
            display = UserAgentType.MOBILE.getUserAgent();
        }

        String qqAuthUrl = "redirect:" + "https://graph.qq.com/oauth2.0/authorize" +
                "?response_type=code" +
                "&client_id=" + qq.getClientId() +
                "&redirect_uri=" + qq.getRedirectUri() +
                "&state=" + qq.getState() +
                "&scope=" + qq.getScope() +
                "&display=" + display;

        log.info("qq auth url: {}", qqAuthUrl);

        return qqAuthUrl;
    }

    /**
     * 防盗链检查
     *
     * @return 防盗链检查结果
     */
    private boolean isSecurityChain() {
        // 获取请求来源地址
        String refererUrl = request.getHeader("referer");

        if (refererUrl == null) {
            return false;
        }
        if (refererUrl.startsWith("https://skill6")) {
            return true;
        }
        if (refererUrl.startsWith("http://skill6")) {
            return true;
        }
        if (refererUrl.startsWith("http://localhost")) {
            return true;
        }

        return refererUrl.startsWith("http://127.0.0.1");
    }
}
