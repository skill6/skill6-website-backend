package cn.skill6.website.dao.intf.visit;

import cn.skill6.common.entity.po.visit.VisitRecord;

import java.util.Date;
import java.util.List;

/**
 * 访问记录操作接口
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月24日 上午12:31:23
 */
public interface VisitRecordDao {
    int deleteByVisitId(Long visitId);

    void addVisitRecord(VisitRecord visitRecord);

    VisitRecord findByVisitId(Long visitId);

    List<VisitRecord> findAll();

    void modifyByVisitId(VisitRecord visitRecord);

    int getOnlineCount(Date today, Date currentTime);
}
