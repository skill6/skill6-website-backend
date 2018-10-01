package cn.skill6.common.entity.po.other;

import java.util.Date;

/**
 * 网站版本信息实体类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月15日 下午11:37:56
 */
public class VersionInfo {
  private Long versionId;

  private String versionUserId;

  private String versionNumber;

  private Date versionReleaseTime;

  private String versionContent;

  @Override
  public String toString() {
    return "VersionInfo [versionId="
        + versionId
        + ", versionUserId="
        + versionUserId
        + ", versionNumber="
        + versionNumber
        + ", versionReleaseTime="
        + versionReleaseTime
        + ", versionContent="
        + versionContent
        + "]";
  }

  public VersionInfo(
      Long versionId,
      String versionUserId,
      String versionNumber,
      Date versionReleaseTime,
      String versionContent) {
    this.versionId = versionId;
    this.versionUserId = versionUserId;
    this.versionNumber = versionNumber;
    this.versionReleaseTime = versionReleaseTime;
    this.versionContent = versionContent;
  }

  public VersionInfo() {
    super();
  }

  public Long getVersionId() {
    return versionId;
  }

  public void setVersionId(Long versionId) {
    this.versionId = versionId;
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

  public Date getVersionReleaseTime() {
    return versionReleaseTime;
  }

  public void setVersionReleaseTime(Date versionReleaseTime) {
    this.versionReleaseTime = versionReleaseTime;
  }

  public String getVersionContent() {
    return versionContent;
  }

  public void setVersionContent(String versionContent) {
    this.versionContent = versionContent == null ? null : versionContent.trim();
  }
}
