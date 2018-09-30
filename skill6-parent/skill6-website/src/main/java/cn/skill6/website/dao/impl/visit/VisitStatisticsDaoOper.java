package cn.skill6.website.dao.impl.visit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.visit.VisitStatistics;
import cn.skill6.website.dao.intf.visit.VisitStatisticsDao;
import cn.skill6.website.dao.mappers.visit.VisitStatisticsMapper;

/**
 * 访问统计操作实现类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月28日 上午12:20:49
 */
public class VisitStatisticsDaoOper implements VisitStatisticsDao {
  private static final Logger logger = LoggerFactory.getLogger(VisitStatisticsDaoOper.class);

  @Autowired private VisitStatisticsMapper visitStatisticsMapper;

  @Override
  public int deleteByVisitId(Long visitId) {
    logger.warn("删除id为{}的访问统计", visitId);

    return visitStatisticsMapper.deleteByPrimaryKey(visitId);
  }

  @Override
  public int addVisitStatistics(VisitStatistics visitStatistics) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public VisitStatistics findByVisitId(Long visitId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<VisitStatistics> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByVisitId(VisitStatistics visitStatistics) {
    // TODO Auto-generated method stub
    return 0;
  }
}
