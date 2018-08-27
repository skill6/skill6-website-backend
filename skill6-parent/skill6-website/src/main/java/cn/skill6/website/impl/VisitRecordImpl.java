package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.VisitRecord;
import cn.skill6.service.intf.basic.VisitRecordOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:20:33
 */
public class VisitRecordImpl implements VisitRecordOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitRecordOper#deleteByVisitId(java.lang.Long)
   */
  @Override
  public int deleteByVisitId(Long visitId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitRecordOper#addVisitRecord(cn.skill6.common.entity.po.VisitRecord)
   */
  @Override
  public int addVisitRecord(VisitRecord visitRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitRecordOper#findByVisitId(java.lang.Long)
   */
  @Override
  public VisitRecord findByVisitId(Long visitId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitRecordOper#findAll()
   */
  @Override
  public List<VisitRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitRecordOper#modifyByVisitId(cn.skill6.common.entity.po.VisitRecord)
   */
  @Override
  public int modifyByVisitId(VisitRecord visitRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
