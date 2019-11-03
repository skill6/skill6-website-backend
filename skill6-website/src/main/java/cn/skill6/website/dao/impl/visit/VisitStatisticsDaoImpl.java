package cn.skill6.website.dao.impl.visit;

import cn.skill6.common.entity.po.visit.VisitStatistics;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.visit.VisitStatisticsDao;
import cn.skill6.website.dao.mappers.visit.VisitStatisticsMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访问统计操作实现类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月28日 上午12:20:49
 */
@Slf4j
@Repository
public class VisitStatisticsDaoImpl implements VisitStatisticsDao {

    @Autowired
    private VisitStatisticsMapper visitStatisticsMapper;

    @Override
    public int deleteByVisitId(Long visitId) {
        log.warn("删除id为{}的访问统计", visitId);

        return visitStatisticsMapper.deleteByPrimaryKey(visitId);
    }

    @Override
    public void addVisitStatistics(VisitStatistics visitStatistics) {
        Long visitId = visitStatistics.getStatisticsId();
        if (visitId == null) {
            visitId = SequenceManager.getNextId();
        }

        // 当日有人在线在插入新记录，默认该在线用户计数为1

        // 初始化当日最大在线人数为1
        visitStatistics.setStatisticsOnlineMax(new Integer(1));
        // 初始化当日访问量为1
        visitStatistics.setStatisticsCurrentDay(new Integer(1));

        // 初始化访问总量为 以往访问总量+1
        // TODO - 根据最大id或者日期查询昨天统计的访问总量
        int currVisitTotalCount = 1;
        visitStatistics.setStatisticsTotalCount(currVisitTotalCount + 1);

        visitStatisticsMapper.insert(visitStatistics);
        log.info("成功插入id为{}的访问记录统计,{}", visitId, visitStatistics);
    }

    @Override
    public VisitStatistics findByVisitId(Long visitId) {
        if (visitId == null) {
            throw new NullPointerException("访问记录id不能为null");
        }

        VisitStatistics visitStatistics = visitStatisticsMapper.selectByPrimaryKey(visitId);
        log.info("找到id为{}的访问统计{}", visitId, visitStatistics);

        return visitStatistics;
    }

    @Override
    public List<VisitStatistics> findAll() {
        List<VisitStatistics> visitStatistics = visitStatisticsMapper.selectAll();
        log.info("找到所有访问统计,{}", visitStatistics);

        return visitStatistics;
    }

    @Override
    public void modifyByVisitId(VisitStatistics visitStatistics) {
        if (visitStatistics.getStatisticsId() == null) {
            throw new NullPointerException("访问记录id不能为null");
        }
        if (visitStatistics.getStatisticsOnlineMax() == null) {
            throw new NullPointerException("访问最大在线人数不能为null");
        }
        if (visitStatistics.getStatisticsCurrentDay() == null) {
            throw new NullPointerException("当日访问总量不能为null");
        }
        if (visitStatistics.getStatisticsTotalCount() == null) {
            throw new NullPointerException("所有访问总量不能为null");
        }

        visitStatisticsMapper.updateByPrimaryKey(visitStatistics);
        log.info("成功修改当日访问记录,{}", visitStatistics);
    }

    @Override
    public VisitStatistics findByCurrentDate() {
        return visitStatisticsMapper.findByCurrentDate();
    }

}
