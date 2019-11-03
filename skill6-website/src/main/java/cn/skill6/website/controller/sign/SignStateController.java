package cn.skill6.website.controller.sign;

import cn.skill6.common.entity.vo.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录状态控制器
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-15 01:57
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class SignStateController {

    @GetMapping(value = "/authenticated")
    public ResponseJson getLoginState() {
        Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        log.info("session id: {}, isAuthenticated： {}", subject.getSession().getId(), authenticated);

        return ResponseJson.build(authenticated);
    }

    @PostMapping(value = "/logout")
    public ResponseJson logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        log.info("logout success");

        return ResponseJson.build(true);
    }

}
