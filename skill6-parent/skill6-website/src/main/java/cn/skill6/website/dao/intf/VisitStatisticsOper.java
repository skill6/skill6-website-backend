package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.VisitStatistics;

/**
 * 访问统计操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:31:51
 */
public interface VisitStatisticsOper {
  int deleteByVisitId(Long visitId);

  int addVisitStatistics(VisitStatistics visitStatistics);

  VisitStatistics findByVisitId(Long visitId);

  List<VisitStatistics> findAll();

  int modifyByVisitId(VisitStatistics visitStatistics);
}
