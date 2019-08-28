package cn.skill6.website.controller.sign;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.service.sign.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册控制器
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-03 03:07
 */
@Slf4j
@RestController
@RequestMapping("/register")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping
    public String signUp(String userName, String password) {
        UserPrivacyInfo userPrivacyInfo = new UserPrivacyInfo();
        userPrivacyInfo.setUserName(userName);
        userPrivacyInfo.setUserPassword(password);
        userPrivacyInfo.setUserLoginFrom(LoginType.USERNAME.getEnumName());
        userPrivacyInfo.setUserType("100");

        signUpService.createUser(userPrivacyInfo);

        return JacksonUtil.toStr(new ResponseJson(true, userName));
    }

}
