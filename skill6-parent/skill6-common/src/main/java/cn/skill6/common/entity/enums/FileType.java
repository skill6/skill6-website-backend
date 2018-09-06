package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 文件类型枚举
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月4日 下午11:36:18
 */
public enum FileType implements BaseEnum<Enum<FileType>, String> {
  ZIP("100", "zip压缩包");

  private String stateCode;
  private String description;

  /**
   * @param stateCode
   * @param description
   */
  private FileType(String stateCode, String description) {
    this.stateCode = stateCode;
    this.description = description;
  }

  /* (non-Javadoc)
   * @see cn.skill6.common.entity.enums.intf.BaseEnum#getStateCode()
   */
  @Override
  public String getStateCode() {
    return stateCode;
  }

  /* (non-Javadoc)
   * @see cn.skill6.common.entity.enums.intf.BaseEnum#getDescrition()
   */
  @Override
  public String getDescrition() {
    return description;
  }
}
