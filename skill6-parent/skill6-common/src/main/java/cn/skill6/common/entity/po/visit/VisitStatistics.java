package cn.skill6.common.entity.po.visit;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 访问统计实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:38:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitStatistics {
  private Long visitId;

  private Date visitDate;

  private Integer visitOnlineMax;

  private Integer visitCurrentDay;

  private Integer visitTotalCount;
}
