package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 状态枚举
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月23日 上午1:19:52
 */
public enum UserState implements BaseEnum<Enum<UserState>, String> {
  /** 用户有效状态 */
  VALID("valid", "有效状态"),
  /** 用户锁定状态 */
  LOCKED("locked", "锁定"),
  /** 用户注销状态 */
  INVALID("invalid", "注销");

  /** 长度不超过16 */
  private String stateCode;

  private String description;

  private UserState(String stateCode, String description) {
    this.stateCode = stateCode;
    this.description = description;
  }

  @Override
  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  @Override
  public String getDescrition() {
    return description;
  }

  public void setDescrition(String description) {
    this.description = description;
  }
}
