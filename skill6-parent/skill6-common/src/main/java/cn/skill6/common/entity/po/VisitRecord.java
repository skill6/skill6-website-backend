package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 访问记录实体类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:38:12
 */
public class VisitRecord {
  private Long visitId;

  private Date visitStartTime;

  private Date visitEndTime;

  private String visitContentType;

  private Long visitContentId;

  private Long visitUserId;

  public VisitRecord(
      Long visitId,
      Date visitStartTime,
      Date visitEndTime,
      String visitContentType,
      Long visitContentId,
      Long visitUserId) {
    this.visitId = visitId;
    this.visitStartTime = visitStartTime;
    this.visitEndTime = visitEndTime;
    this.visitContentType = visitContentType;
    this.visitContentId = visitContentId;
    this.visitUserId = visitUserId;
  }

  public VisitRecord() {
    super();
  }

  public Long getVisitId() {
    return visitId;
  }

  public void setVisitId(Long visitId) {
    this.visitId = visitId;
  }

  public Date getVisitStartTime() {
    return visitStartTime;
  }

  public void setVisitStartTime(Date visitStartTime) {
    this.visitStartTime = visitStartTime;
  }

  public Date getVisitEndTime() {
    return visitEndTime;
  }

  public void setVisitEndTime(Date visitEndTime) {
    this.visitEndTime = visitEndTime;
  }

  public String getVisitContentType() {
    return visitContentType;
  }

  public void setVisitContentType(String visitContentType) {
    this.visitContentType = visitContentType == null ? null : visitContentType.trim();
  }

  public Long getVisitContentId() {
    return visitContentId;
  }

  public void setVisitContentId(Long visitContentId) {
    this.visitContentId = visitContentId;
  }

  public Long getVisitUserId() {
    return visitUserId;
  }

  public void setVisitUserId(Long visitUserId) {
    this.visitUserId = visitUserId;
  }
}
