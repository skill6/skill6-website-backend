package cn.skill6.common.entity.po.feature;

import java.util.Date;

/**
 * 讨论区实体类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:32:21
 */
public class FeatureDiscussArea {
  private Long discussId;

  private Long discussBelongId;

  private Long discussParentId;

  private String discussComitterId;

  private Date discussCreateTime;

  private Boolean discussValid;

  private String discussContent;

  @Override
  public String toString() {
    return "FeatureDiscussArea [discussId="
        + discussId
        + ", discussBelongId="
        + discussBelongId
        + ", discussParentId="
        + discussParentId
        + ", discussComitterId="
        + discussComitterId
        + ", discussCreateTime="
        + discussCreateTime
        + ", discussValid="
        + discussValid
        + ", discussContent="
        + discussContent
        + "]";
  }

  public FeatureDiscussArea(
      Long discussId,
      Long discussBelongId,
      Long discussParentId,
      String discussComitterId,
      Date discussCreateTime,
      Boolean discussValid,
      String discussContent) {
    this.discussId = discussId;
    this.discussBelongId = discussBelongId;
    this.discussParentId = discussParentId;
    this.discussComitterId = discussComitterId;
    this.discussCreateTime = discussCreateTime;
    this.discussValid = discussValid;
    this.discussContent = discussContent;
  }

  public FeatureDiscussArea() {
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

  public Date getDiscussCreateTime() {
    return discussCreateTime;
  }

  public void setDiscussCreateTime(Date discussCreateTime) {
    this.discussCreateTime = discussCreateTime;
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
