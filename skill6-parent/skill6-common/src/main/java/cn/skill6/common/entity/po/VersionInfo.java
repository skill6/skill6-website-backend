package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 网站版本信息实体类
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:37:56
 * @version 1.0.0
 */
public class VersionInfo {
  private String versionId;

  private String versionUserId;

  private String versionNumber;

  private Date versionDate;

  private String versionContent;

  public VersionInfo(
      String versionId,
      String versionUserId,
      String versionNumber,
      Date versionDate,
      String versionContent) {
    this.versionId = versionId;
    this.versionUserId = versionUserId;
    this.versionNumber = versionNumber;
    this.versionDate = versionDate;
    this.versionContent = versionContent;
  }

  public VersionInfo() {
    super();
  }

  public String getVersionId() {
    return versionId;
  }

  public void setVersionId(String versionId) {
    this.versionId = versionId == null ? null : versionId.trim();
  }

  public String getVersionUserId() {
    return versionUserId;
  }

  public void setVersionUserId(String versionUserId) {
    this.versionUserId = versionUserId == null ? null : versionUserId.trim();
  }

  public String getVersionNumber() {
    return versionNumber;
  }

  public void setVersionNumber(String versionNumber) {
    this.versionNumber = versionNumber == null ? null : versionNumber.trim();
  }

  public Date getVersionDate() {
    return versionDate;
  }

  public void setVersionDate(Date versionDate) {
    this.versionDate = versionDate;
  }

  public String getVersionContent() {
    return versionContent;
  }

  public void setVersionContent(String versionContent) {
    this.versionContent = versionContent == null ? null : versionContent.trim();
  }
}
