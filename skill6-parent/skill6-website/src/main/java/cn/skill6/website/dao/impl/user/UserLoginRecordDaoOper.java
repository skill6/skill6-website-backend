package cn.skill6.website.dao.impl.user;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.user.UserLoginRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.user.UserLoginRecordDao;
import cn.skill6.website.dao.mappers.user.UserLoginRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 登录记录操作实现类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月28日 上午12:18:47
 */
public class UserLoginRecordDaoOper implements UserLoginRecordDao {
  private static final Logger logger = LoggerFactory.getLogger(UserLoginRecordDaoOper.class);

  @Autowired private UserLoginRecordMapper userLoginRecordMapper;

  @Override
  public int deleteByLoginId(Long loginId) {
    logger.warn("删除id为{}的登录记录", loginId);

    return userLoginRecordMapper.deleteByPrimaryKey(loginId);
  }

  @Override
  public void addLoginRecord(UserLoginRecord userLoginRecord) {
    if (userLoginRecord.getLoginUserId() == null) {
      throw new NullPointerException("登录用户id不能为null");
    }
    if (userLoginRecord.getLoginSuccess() == null) {
      throw new NullPointerException("登录结果不能为null");
    }

    Long loginId = userLoginRecord.getLoginId();
    if (loginId == null) {
      loginId = SequenceManager.getNextId();
    }

    userLoginRecord.setLoginTime(new Date());
    userLoginRecordMapper.insert(userLoginRecord);
    logger.info("成功插入新的用户登录记录,{}", userLoginRecord);
  }

  @Override
  public UserLoginRecord findByLoginId(Long loginId) {
    if (loginId == null) {
      throw new NullPointerException("登录id不能为null");
    }

    UserLoginRecord userLoginRecord = userLoginRecordMapper.selectByPrimaryKey(loginId);
    logger.info("找到id为{}的用户登录记录,{}", loginId, userLoginRecord);

    return userLoginRecord;
  }

  @Override
  public List<UserLoginRecord> findAll() {
    List<UserLoginRecord> userLoginRecords = userLoginRecordMapper.selectAll();
    logger.info("找到所有用户登录记录,{}", userLoginRecords);

    return userLoginRecords;
  }

  @Override
  public void modifyByLoginId(UserLoginRecord userLoginRecord) {
    throw new Skill6Exception("暂不支持修改用户登录记录");
  }
}
