package cn.skill6.common.entity.po.visit;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 访问统计实体类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月15日 下午11:38:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitStatistics {

  private Long statisticsId;

  private Date statisticsDate;

  private Integer statisticsOnlineMax;

  private Integer statisticsCurrentDay;

  private Integer statisticsTotalCount;
}
