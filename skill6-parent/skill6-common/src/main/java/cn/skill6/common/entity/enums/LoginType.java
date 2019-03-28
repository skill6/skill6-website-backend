package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 登录方式枚举
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年5月14日 下午5:06:55
 */
public enum LoginType implements BaseEnum<Enum<LoginType>, String> {
  USERNAME("username", "用户名登录", "/login/username"),
  EMAIL("email", "邮箱登录", "/login/email"),
  PHONE("phone", "手机登录", "/login/phone"),
  GITHUB("github", "github登录", "/login/github"),
  GOOGLE("google", "google登录", "/login/google"),
  QQ("qq", "qq登录", "/login/qq"),
  WECHAT("wechat", "微信登录", "/login/wechat");

  /** 登录类型的小写，设置长度不超过8 */
  private String stateCode;

  private String description;
  private String uri;

  @Override
  public String getStateCode() {
    return stateCode;
  }

  @Override
  public String getDescrition() {
    return description;
  }

  /** @return the uri */
  public String getUri() {
    return uri;
  }

  /** @param uri the uri to set */
  public void setUri(String uri) {
    this.uri = uri;
  }

  /**
   * @param stateCode
   * @param description
   */
  private LoginType(String stateCode, String description) {
    this.stateCode = stateCode;
    this.description = description;
  }

  /**
   * @param stateCode
   * @param description
   * @param uri
   */
  private LoginType(String stateCode, String description, String uri) {
    this.stateCode = stateCode;
    this.description = description;
    this.uri = uri;
  }
}
