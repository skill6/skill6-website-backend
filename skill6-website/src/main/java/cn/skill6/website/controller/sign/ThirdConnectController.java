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
        if (!securityChainCheck()) {
            ThirdConnectController.log.warn("security chain check fail");
            return "redirect:/error";
        }

        Skill6Properties.GitHub github = skill6Properties.getGitHub();

        String githubAuthUrl = new StringBuilder().append("redirect:")
                .append("https://github.com/login/oauth/authorize").append("?client_id=").append(github.getClientId())
                .append("&redirect_uri=").append(github.getRedirectUri()).toString();

        return githubAuthUrl;
    }

    @GetMapping(value = "/qq")
    public String connectByQq() throws ServletException, IOException {
        if (!securityChainCheck()) {
            ThirdConnectController.log.warn("security chain check fail");
            return "redirect:/error";
        }

        Skill6Properties.QQ qq = skill6Properties.getQq();

        String display = UserAgentType.PC.getUserAgent();
        if (JudgeIsMobile.isMobile(request.getHeader("user-agent"))) {
            display = UserAgentType.MOBILE.getUserAgent();
        }

        String qqAuthUrl = new StringBuilder("redirect:").append("https://graph.qq.com/oauth2.0/authorize")
                .append("?response_type=code").append("&client_id=").append(qq.getClientId()).append("&redirect_uri=")
                .append(qq.getRedirectUri()).append("&state=").append(qq.getState()).append("&scope=").append(qq.getScope())
                .append("&display=").append(display).toString();

        return qqAuthUrl;
    }

    /**
     * 防盗链检查
     *
     * @return 防盗链检查结果
     * @throws IOException
     */
    private boolean securityChainCheck() throws IOException {
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
        if (refererUrl.startsWith("http://127.0.0.1")) {
            return true;
        }

        return false;
    }
}
