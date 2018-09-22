package cn.skill6.website.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.VisitStatistics;
import cn.skill6.website.dao.VisitStatisticsMapper;
import cn.skill6.website.dao.intf.VisitStatisticsOper;

/**
 * 访问统计操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:20:49
 */
public class VisitStatisticsImpl implements VisitStatisticsOper {
  private static final Logger logger = LoggerFactory.getLogger(VisitStatisticsImpl.class);

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
