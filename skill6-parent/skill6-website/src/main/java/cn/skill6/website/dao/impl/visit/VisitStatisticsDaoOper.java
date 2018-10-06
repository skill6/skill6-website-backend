package cn.skill6.website.dao.impl.visit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.visit.VisitStatistics;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.visit.VisitStatisticsDao;
import cn.skill6.website.dao.mappers.visit.VisitStatisticsMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 访问统计操作实现类
 *
 * @author 何明胜
 * @version 1.3
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
  public void addVisitStatistics(VisitStatistics visitStatistics) {
    Long visitId = visitStatistics.getVisitId();
    if (visitId == null) {
      visitId = SequenceManager.getNextId();
    }

    // 当日有人在线在插入新记录，默认该在线用户计数为1

    // 初始化当日最大在线人数为1
    visitStatistics.setVisitOnlineMax(new Integer(1));
    // 初始化当日访问量为1
    visitStatistics.setVisitCurrentDay(new Integer(1));

    // 初始化访问总量为 以往访问总量+1
    // TODO - 根据最大id或者日期查询昨天统计的访问总量
    int currVisitTotalCount = 1;
    visitStatistics.setVisitTotalCount(currVisitTotalCount + 1);

    visitStatisticsMapper.insert(visitStatistics);
    logger.info("成功插入id为{}的访问记录统计,{}", visitId, visitStatistics);
  }

  @Override
  public VisitStatistics findByVisitId(Long visitId) {
    if (visitId == null) {
      throw new NullPointerException("访问记录id不能为null");
    }

    VisitStatistics visitStatistics = visitStatisticsMapper.selectByPrimaryKey(visitId);
    logger.info("找到id为{}的访问统计{}", visitId, visitStatistics);

    return visitStatistics;
  }

  @Override
  public List<VisitStatistics> findAll() {
    List<VisitStatistics> visitStatistics = visitStatisticsMapper.selectAll();
    logger.info("找到所有访问统计,{}", visitStatistics);

    return visitStatistics;
  }

  @Override
  public void modifyByVisitId(VisitStatistics visitStatistics) {
    if (visitStatistics.getVisitId() == null) {
      throw new NullPointerException("访问记录id不能为null");
    }
    if (visitStatistics.getVisitOnlineMax() == null) {
      throw new NullPointerException("访问最大在线人数不能为null");
    }
    if (visitStatistics.getVisitCurrentDay() == null) {
      throw new NullPointerException("当日访问总量不能为null");
    }
    if (visitStatistics.getVisitTotalCount() == null) {
      throw new NullPointerException("所有访问总量不能为null");
    }

    visitStatisticsMapper.updateByPrimaryKey(visitStatistics);
    logger.info("成功修改当日访问记录,{}", visitStatistics);
  }
}
