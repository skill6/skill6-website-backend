package cn.skill6.website.dao;

import cn.skill6.common.entity.po.VisitRecord;
import java.util.List;

/**
 * 访问记录mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:42:06
 */
public interface VisitRecordMapper {
  int deleteByPrimaryKey(Long visitId);

  int insert(VisitRecord visitRecord);

  VisitRecord selectByPrimaryKey(Long visitId);

  List<VisitRecord> selectAll();

  int updateByPrimaryKey(VisitRecord visitRecord);
}
