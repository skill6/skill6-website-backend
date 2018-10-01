package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 排序枚举
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月21日 下午10:34:15
 */
public enum SortType implements BaseEnum<Enum<SortType>, String> {
  ASCENDING("ASC", "升序排列"),
  DESCENDING("DESC", "降序排列");

  private String stateCode;
  private String description;

  /**
   * @param stateCode
   * @param description
   */
  private SortType(String stateCode, String description) {
    this.stateCode = stateCode;
    this.description = description;
  }

  @Override
  public String getStateCode() {
    return stateCode;
  }

  @Override
  public String getDescrition() {
    return description;
  }

  /** @return the description */
  public String getDescription() {
    return description;
  }

  /** @param description the description to set */
  public void setDescription(String description) {
    this.description = description;
  }

  /** @param stateCode the stateCode to set */
  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }
}
