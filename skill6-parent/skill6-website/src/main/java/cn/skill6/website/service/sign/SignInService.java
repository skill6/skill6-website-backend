package cn.skill6.website.service.sign;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.microservice.sign.SignInSvc;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import lombok.extern.slf4j.Slf4j;

/**
 * 登录服务实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月23日 下午10:23:56
 */
@Slf4j
@Service
public class SignInService implements SignInSvc {

  @Override
  public void loginByGitHub(String authCode) {
    AccountPasswordTypeToken token = new AccountPasswordTypeToken(authCode, LoginType.GITHUB);
    SecurityUtils.getSubject().login(token);
    log.info("login by {} success", LoginType.GITHUB.getStateCode());
  }

  @Override
  public void loginByGitQq(String authCode) {
    AccountPasswordTypeToken token = new AccountPasswordTypeToken(authCode, LoginType.QQ);
    SecurityUtils.getSubject().login(token);
    log.info("login by {} success", LoginType.QQ.getStateCode());
  }
}
