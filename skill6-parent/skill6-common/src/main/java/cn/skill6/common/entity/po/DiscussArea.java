package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 主题讨论区实体类
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:32:21
 * @version 1.0.0
 */
public class DiscussArea {
  private Long discussId;

  private Long discussBelongId;

  private Long discussParentId;

  private String discussComitterId;

  private Date discussCreateDate;

  private Boolean discussValid;

  private String discussContent;

  public DiscussArea(
      Long discussId,
      Long discussBelongId,
      Long discussParentId,
      String discussComitterId,
      Date discussCreateDate,
      Boolean discussValid,
      String discussContent) {
    this.discussId = discussId;
    this.discussBelongId = discussBelongId;
    this.discussParentId = discussParentId;
    this.discussComitterId = discussComitterId;
    this.discussCreateDate = discussCreateDate;
    this.discussValid = discussValid;
    this.discussContent = discussContent;
  }

  public DiscussArea() {
    super();
  }

  public Long getDiscussId() {
    return discussId;
  }

  public void setDiscussId(Long discussId) {
    this.discussId = discussId;
  }

  public Long getDiscussBelongId() {
    return discussBelongId;
  }

  public void setDiscussBelongId(Long discussBelongId) {
    this.discussBelongId = discussBelongId;
  }

  public Long getDiscussParentId() {
    return discussParentId;
  }

  public void setDiscussParentId(Long discussParentId) {
    this.discussParentId = discussParentId;
  }

  public String getDiscussComitterId() {
    return discussComitterId;
  }

  public void setDiscussComitterId(String discussComitterId) {
    this.discussComitterId = discussComitterId == null ? null : discussComitterId.trim();
  }

  public Date getDiscussCreateDate() {
    return discussCreateDate;
  }

  public void setDiscussCreateDate(Date discussCreateDate) {
    this.discussCreateDate = discussCreateDate;
  }

  public Boolean getDiscussValid() {
    return discussValid;
  }

  public void setDiscussValid(Boolean discussValid) {
    this.discussValid = discussValid;
  }

  public String getDiscussContent() {
    return discussContent;
  }

  public void setDiscussContent(String discussContent) {
    this.discussContent = discussContent == null ? null : discussContent.trim();
  }
}
