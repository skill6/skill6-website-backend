package cn.skill6.website.dao.mappers.visit;

import cn.skill6.common.entity.po.visit.VisitStatistics;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访问统计mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:42:17
 */
@Repository
public interface VisitStatisticsMapper {
    int deleteByPrimaryKey(Long visitId);

    int insert(VisitStatistics visitStatistics);

    VisitStatistics selectByPrimaryKey(Long visitId);

    List<VisitStatistics> selectAll();

    int updateByPrimaryKey(VisitStatistics visitStatistics);

    VisitStatistics findByCurrentDate();
}
