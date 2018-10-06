package cn.skill6.website.service.complex;

import cn.skill6.website.config.Skill6Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Google 验证码人机结果校验器
 *
 * @author liujichun
 * @version 1.0.0
 */
@Service
@Slf4j
public class RecaptchaValidator {

  @Autowired private RestTemplate restTemplate;

  @Autowired private Skill6Properties skill6Properties;

  private String secret;

  private String verifyUrl;

  @PostConstruct
  public void init() {
    this.secret = skill6Properties.getRecaptcha().getSecretKey();
    if (StringUtils.isEmpty(this.secret)) {
      log.warn("Recaptcha Validator secret 获取失败，请检查设置");
    }
    this.verifyUrl = skill6Properties.getRecaptcha().getVerifyUrl();
    if (StringUtils.isEmpty(this.verifyUrl)) {
      log.warn("Recaptcha Validator url 获取失败，请检查设置");
    }
  }

  private boolean validate0(String remoteIp, String response) {
    Req req = new Req();
    req.setSecret(secret);
    req.setRemoteip(remoteIp);
    req.setResponse(response);
    restTemplate.postForObject(verifyUrl, req, Object.class);
    // todo liujichun
    return true;
  }

  public boolean validate(String remoteIp, String respose) {
    return validate0(remoteIp, respose);
  }

  public static class Req {
    private String secret;
    private String response;
    private String remoteip;

    public String getSecret() {
      return secret;
    }

    public void setSecret(String secret) {
      this.secret = secret;
    }

    public String getResponse() {
      return response;
    }

    public void setResponse(String response) {
      this.response = response;
    }

    public String getRemoteip() {
      return remoteip;
    }

    public void setRemoteip(String remoteip) {
      this.remoteip = remoteip;
    }
  }
}
