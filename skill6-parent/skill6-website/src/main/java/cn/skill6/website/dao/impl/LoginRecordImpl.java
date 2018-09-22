package cn.skill6.website.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.LoginRecord;
import cn.skill6.website.dao.LoginRecordMapper;
import cn.skill6.website.dao.intf.LoginRecordOper;

/**
 * 登录记录操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:18:47
 */
public class LoginRecordImpl implements LoginRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(LoginRecordImpl.class);

  @Autowired private LoginRecordMapper loginRecordMapper;

  @Override
  public int deleteByLoginId(Long loginId) {
    logger.warn("删除id为{}的登录记录", loginId);

    return loginRecordMapper.deleteByPrimaryKey(loginId);
  }

  @Override
  public int addLoginRecord(LoginRecord loginRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public LoginRecord findByLoginId(Long loginId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<LoginRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByLoginId(LoginRecord loginRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
