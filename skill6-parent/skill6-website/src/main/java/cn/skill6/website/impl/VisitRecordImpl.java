package cn.skill6.website.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.VisitRecord;
import cn.skill6.service.intf.basic.VisitRecordOper;
import cn.skill6.website.dao.VisitRecordMapper;

/**
 * 访问记录操作实现类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:20:33
 */
public class VisitRecordImpl implements VisitRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(VisitRecordImpl.class);

  @Autowired private VisitRecordMapper visitRecordMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VisitRecordOper#deleteByVisitId(java.lang.Long)
   */
  @Override
  public int deleteByVisitId(Long visitId) {
	  logger.warn("删除id为{}的访问记录", visitId);

	    return visitRecordMapper.deleteByPrimaryKey(visitId);
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
