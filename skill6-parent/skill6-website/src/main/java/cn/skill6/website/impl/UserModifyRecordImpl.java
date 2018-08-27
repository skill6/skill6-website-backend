package cn.skill6.website.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.UserModifyRecord;
import cn.skill6.service.intf.basic.UserModifyRecordOper;
import cn.skill6.website.dao.UserModifyRecordMapper;

/**
 * 用户信息修改记录操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:19:34
 */
public class UserModifyRecordImpl implements UserModifyRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(UserModifyRecordImpl.class);

  @Autowired private UserModifyRecordMapper userModifyRecordMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserModifyRecordOper#deleteByUserId(java.lang.String)
   */
  @Override
  public int deleteByUserId(String userId) {
    logger.warn("删除id为{}的用户信息修改记录", userId);

    return userModifyRecordMapper.deleteByPrimaryKey(userId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserModifyRecordOper#addUserModifyRecord(cn.skill6.common.entity.po.UserModifyRecord)
   */
  @Override
  public int addUserModifyRecord(UserModifyRecord userModifyRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserModifyRecordOper#findByUserId(java.lang.String)
   */
  @Override
  public UserModifyRecord findByUserId(String userId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserModifyRecordOper#findAll()
   */
  @Override
  public List<UserModifyRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserModifyRecordOper#modifyByUserId(cn.skill6.common.entity.po.UserModifyRecord)
   */
  @Override
  public int modifyByUserId(UserModifyRecord userModifyRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
