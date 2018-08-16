package cn.skill6.website.dao;

import cn.skill6.common.entity.po.VisitStatistics;
import java.util.List;

/**
 * 访问统计mapper
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:42:17
 * @version 1.0.0
 */
public interface VisitStatisticsMapper {
  int deleteByPrimaryKey(Long visitId);

  int insert(VisitStatistics record);

  VisitStatistics selectByPrimaryKey(Long visitId);

  List<VisitStatistics> selectAll();

  int updateByPrimaryKey(VisitStatistics record);
}
