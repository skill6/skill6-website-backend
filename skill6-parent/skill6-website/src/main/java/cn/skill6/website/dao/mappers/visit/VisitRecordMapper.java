package cn.skill6.website.dao.mappers.visit;

import cn.skill6.common.entity.po.visit.VisitRecord;
import java.util.List;

public interface VisitRecordMapper {
    int deleteByPrimaryKey(Long visitId);

    int insert(VisitRecord record);

    VisitRecord selectByPrimaryKey(Long visitId);

    List<VisitRecord> selectAll();

    int updateByPrimaryKey(VisitRecord record);
}