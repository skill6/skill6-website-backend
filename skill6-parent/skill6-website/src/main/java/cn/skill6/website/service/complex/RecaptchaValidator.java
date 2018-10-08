package cn.skill6.website.service.complex;

import cn.skill6.website.config.Skill6Properties;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * Google 验证码人机结果校验器
 *
 * @author liujichun
 * @version 1.0.1
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
    log.debug("reCaptcha validate request {}", req);
    Resp resp = restTemplate.postForObject(verifyUrl, req, Resp.class);
    log.debug("reCaptcha validate response {} for {}", resp, req.response);
    return resp.isSuccess();
  }

  public boolean validate(String remoteIp, String respose) {
    return validate0(remoteIp, respose);
  }

  @Data
  public static class Req {
    private String secret;
    private String response;
    private String remoteip;
  }

  /** 部分内容来自https://github.com/mkopylec/recaptcha-spring-boot-starter */
  public static class Resp {
    private boolean success;
    private List<ErrorCode> errorCodes;

    @JsonCreator
    public Resp(
        @JsonProperty("success") boolean success,
        @JsonProperty("error-codes") List<ErrorCode> errorCodes) {
      this.success = success;
      this.errorCodes = errorCodes == null ? new ArrayList<>() : errorCodes;
    }

    public boolean isSuccess() {
      return success;
    }

    @JsonIgnore
    public boolean isFailure() {
      return !success;
    }

    public List<ErrorCode> getErrorCodes() {
      return unmodifiableList(errorCodes);
    }

    public boolean hasError(ErrorCode error) {
      return errorCodes.contains(error);
    }
  }

  /** Google reCaptcha错误码，部分内容来自https://github.com/mkopylec/recaptcha-spring-boot-starter */
  @Slf4j
  public enum ErrorCode {

    // reCAPTCHA verification errors
    MISSING_SECRET_KEY("missing-input-secret"),
    INVALID_SECRET_KEY("invalid-input-secret"),
    MISSING_USER_CAPTCHA_RESPONSE("missing-input-response"),
    INVALID_USER_CAPTCHA_RESPONSE("invalid-input-response"),
    BAD_REQUEST("bad-request"),
    TIMEOUT_OR_DUPLICATE("timeout-or-duplicate"),

    // Custom errors
    MISSING_USERNAME_REQUEST_PARAMETER("missing-username-request-parameter"),
    MISSING_CAPTCHA_RESPONSE_PARAMETER("missing-captcha-response-parameter"),
    VALIDATION_HTTP_ERROR("validation-http-error"),
    UNSUPPORTED_ERROR_CODE("unsupported_error_code");

    private final String text;

    ErrorCode(String text) {
      this.text = text;
    }

    @JsonCreator
    private static ErrorCode fromValue(String value) {
      if (value == null) {
        return null;
      }
      switch (value) {
        case "missing-input-secret":
          return MISSING_SECRET_KEY;
        case "invalid-input-secret":
          return INVALID_SECRET_KEY;
        case "missing-input-response":
          return MISSING_USER_CAPTCHA_RESPONSE;
        case "invalid-input-response":
          return INVALID_USER_CAPTCHA_RESPONSE;
        case "bad-request":
          return BAD_REQUEST;
        case "timeout-or-duplicate":
          return TIMEOUT_OR_DUPLICATE;
        case "missing-username-request-parameter":
          return MISSING_USERNAME_REQUEST_PARAMETER;
        case "missing-captcha-response-parameter":
          return MISSING_CAPTCHA_RESPONSE_PARAMETER;
        case "validation-http-error":
          return VALIDATION_HTTP_ERROR;
        default:
          log.warn("Unsupported error code: {}", value);
          return UNSUPPORTED_ERROR_CODE;
      }
    }

    @JsonValue
    public String getText() {
      return text;
    }
  }
}
