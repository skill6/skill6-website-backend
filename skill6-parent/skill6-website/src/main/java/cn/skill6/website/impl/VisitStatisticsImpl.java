package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.VisitStatistics;
import cn.skill6.service.intf.basic.VisitStatisticsOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:20:49
 */
public class VisitStatisticsImpl implements VisitStatisticsOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitStatisticsOper#deleteByVisitId(java.lang.Long)
   */
  @Override
  public int deleteByVisitId(Long visitId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitStatisticsOper#addVisitStatistics(cn.skill6.common.entity.po.VisitStatistics)
   */
  @Override
  public int addVisitStatistics(VisitStatistics visitStatistics) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitStatisticsOper#findByVisitId(java.lang.Long)
   */
  @Override
  public VisitStatistics findByVisitId(Long visitId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitStatisticsOper#findAll()
   */
  @Override
  public List<VisitStatistics> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitStatisticsOper#modifyByVisitId(cn.skill6.common.entity.po.VisitStatistics)
   */
  @Override
  public int modifyByVisitId(VisitStatistics visitStatistics) {
    // TODO Auto-generated method stub
    return 0;
  }
}
