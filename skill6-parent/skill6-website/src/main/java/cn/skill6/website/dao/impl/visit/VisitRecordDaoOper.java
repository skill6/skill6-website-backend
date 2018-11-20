package cn.skill6.website.dao.impl.visit;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.visit.VisitRecord;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.visit.VisitRecordDao;
import cn.skill6.website.dao.mappers.visit.VisitRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 访问记录操作实现类
 *
 * @author 何明胜
 * @version 1.3
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
  public void addVisitRecord(VisitRecord visitRecord) {
    if (visitRecord.getVisitContentType() == null) {
      throw new NullPointerException("访问类型不能为null");
    }
    // TODO - 未登录用户是否需要id?
    if (visitRecord.getUserId() == null) {
      throw new NullPointerException("访问用户id不能为空");
    }

    Long visitId = visitRecord.getVisitId();
    if (visitId == null) {
      visitId = SequenceManager.getNextId();
    }

    visitRecord.setVisitStartTime(new Date());
    visitRecord.setVisitEndTime(new Date());

    visitRecordMapper.insert(visitRecord);
    logger.info("成功插入id为{}的访问记录{}", visitId, visitRecord);
  }

  @Override
  public VisitRecord findByVisitId(Long visitId) {
    if (visitId == null) {
      throw new NullPointerException("访问记录id不能为null");
    }

    VisitRecord visitRecord = visitRecordMapper.selectByPrimaryKey(visitId);
    logger.info("找到id为{}的访问记录{}", visitId, visitRecord);

    return visitRecord;
  }

  @Override
  public List<VisitRecord> findAll() {
    List<VisitRecord> visitRecords = visitRecordMapper.selectAll();
    logger.info("找到所有访问记录{}", visitRecords);

    return visitRecords;
  }

  @Override
  public void modifyByVisitId(VisitRecord visitRecord) {
    if (visitRecord.getVisitContentType() == null) {
      throw new NullPointerException("访问类型不能为null");
    }
    // TODO - 未登录用户是否需要id?
    if (visitRecord.getUserId() == null) {
      throw new NullPointerException("访问用户id不能为空");
    }
    if (visitRecord.getVisitId() == null) {
      throw new NullPointerException("访问记录id不能为null");
    }

    visitRecord.setVisitEndTime(new Date());
    visitRecordMapper.updateByPrimaryKey(visitRecord);
    logger.info("成功更新访问记录,{}", visitRecord);
  }
}
