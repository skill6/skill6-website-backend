package cn.skill6.website.dao.intf.visit;

import cn.skill6.common.entity.po.visit.VisitStatistics;

import java.util.List;

/**
 * 访问统计操作接口
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月24日 上午12:31:51
 */
public interface VisitStatisticsDao {
    int deleteByVisitId(Long visitId);

    void addVisitStatistics(VisitStatistics visitStatistics);

    VisitStatistics findByVisitId(Long visitId);

    List<VisitStatistics> findAll();

    void modifyByVisitId(VisitStatistics visitStatistics);

    VisitStatistics findByCurrentDate();
}
