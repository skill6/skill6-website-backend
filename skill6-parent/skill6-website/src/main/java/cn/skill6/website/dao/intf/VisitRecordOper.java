package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.VisitRecord;

/**
 * 访问记录操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:31:23
 */
public interface VisitRecordOper {
  int deleteByVisitId(Long visitId);

  int addVisitRecord(VisitRecord visitRecord);

  VisitRecord findByVisitId(Long visitId);

  List<VisitRecord> findAll();

  int modifyByVisitId(VisitRecord visitRecord);
}
