package cn.skill6.website.dao.mappers.visit;

import cn.skill6.common.entity.po.visit.VisitRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 访问记录
 *
 * @author 何明胜
 * @since 2018年9月30日 下午10:02:29
 */
@Repository
public interface VisitRecordMapper {
    int deleteByPrimaryKey(Long visitId);

    int insert(VisitRecord visitRecord);

    VisitRecord selectByPrimaryKey(Long visitId);

    List<VisitRecord> selectAll();

    int updateByPrimaryKey(VisitRecord visitRecord);

    int getOnlineCount(@Param("today") Date today, @Param("currentTime") Date currentTime);
}
