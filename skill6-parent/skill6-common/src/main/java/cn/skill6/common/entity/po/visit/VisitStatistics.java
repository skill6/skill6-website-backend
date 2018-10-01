package cn.skill6.common.entity.po.visit;

import java.util.Date;

/**
 * 访问统计实体类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月15日 下午11:38:22
 */
public class VisitStatistics {
  private Long visitId;

  private Date visitDate;

  private Integer visitOnlineMax;

  private Integer visitCurrentDay;

  private Integer visitTotalCount;

  @Override
  public String toString() {
    return "VisitStatistics [visitId="
        + visitId
        + ", visitDate="
        + visitDate
        + ", visitOnlineMax="
        + visitOnlineMax
        + ", visitCurrentDay="
        + visitCurrentDay
        + ", visitTotalCount="
        + visitTotalCount
        + "]";
  }

  public VisitStatistics(
      Long visitId,
      Date visitDate,
      Integer visitOnlineMax,
      Integer visitCurrentDay,
      Integer visitTotalCount) {
    this.visitId = visitId;
    this.visitDate = visitDate;
    this.visitOnlineMax = visitOnlineMax;
    this.visitCurrentDay = visitCurrentDay;
    this.visitTotalCount = visitTotalCount;
  }

  public VisitStatistics() {
    super();
  }

  public Long getVisitId() {
    return visitId;
  }

  public void setVisitId(Long visitId) {
    this.visitId = visitId;
  }

  public Date getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(Date visitDate) {
    this.visitDate = visitDate;
  }

  public Integer getVisitOnlineMax() {
    return visitOnlineMax;
  }

  public void setVisitOnlineMax(Integer visitOnlineMax) {
    this.visitOnlineMax = visitOnlineMax;
  }

  public Integer getVisitCurrentDay() {
    return visitCurrentDay;
  }

  public void setVisitCurrentDay(Integer visitCurrentDay) {
    this.visitCurrentDay = visitCurrentDay;
  }

  public Integer getVisitTotalCount() {
    return visitTotalCount;
  }

  public void setVisitTotalCount(Integer visitTotalCount) {
    this.visitTotalCount = visitTotalCount;
  }
}
