package cn.skill6.website.dao.impl.visit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.visit.VisitRecord;
import cn.skill6.website.dao.intf.visit.VisitRecordDao;
import cn.skill6.website.dao.mappers.visit.VisitRecordMapper;

/**
 * 访问记录操作实现类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年8月28日 上午12:20:33
 */
public class VisitRecordDaoOper implements VisitRecordDao {
  private static final Logger logger = LoggerFactory.getLogger(VisitRecordDaoOper.class);

  @Autowired private VisitRecordMapper visitRecordMapper;

  @Override
  public int deleteByVisitId(Long visitId) {
    logger.warn("删除id为{}的访问记录", visitId);

    return visitRecordMapper.deleteByPrimaryKey(visitId);
  }

  @Override
  public int addVisitRecord(VisitRecord visitRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public VisitRecord findByVisitId(Long visitId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<VisitRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByVisitId(VisitRecord visitRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
