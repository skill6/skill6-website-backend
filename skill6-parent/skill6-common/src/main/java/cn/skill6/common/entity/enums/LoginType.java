package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 登录方式枚举
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年5月14日 下午5:06:55
 */
public enum LoginType implements BaseEnum<Enum<LoginType>, String> {
  USERNAME("100", "用户名登录", "login/username"),
  EMAIL("200", "邮箱登录", "login/email"),
  PHONE("300", "手机登录", "login/phone"),
  GITHUB("400", "github登录", "login/github");

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
