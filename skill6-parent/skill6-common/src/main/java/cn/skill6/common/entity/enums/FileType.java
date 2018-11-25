package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 文件类型枚举，是文章附件还是分享的软件等
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年9月4日 下午11:36:18
 */
public enum FileType implements BaseEnum<Enum<FileType>, String> {
  ATTACHMENT("attachment", "附件文件"),
  SHARE_FILES("share_files", "分享提供下载");

  /** 长度不超过16 */
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

  @Override
  public String getStateCode() {
    return stateCode;
  }

  @Override
  public String getDescrition() {
    return description;
  }
}
