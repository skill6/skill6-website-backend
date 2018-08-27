package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.LoginRecord;
import cn.skill6.service.intf.basic.LoginRecordOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:18:47
 */
public class LoginRecordImpl implements LoginRecordOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.LoginRecordOper#deleteByLoginId(java.lang.Long)
   */
  @Override
  public int deleteByLoginId(Long loginId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.LoginRecordOper#addLoginRecord(cn.skill6.common.entity.po.LoginRecord)
   */
  @Override
  public int addLoginRecord(LoginRecord loginRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.LoginRecordOper#findByLoginId(java.lang.Long)
   */
  @Override
  public LoginRecord findByLoginId(Long loginId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.LoginRecordOper#findAll()
   */
  @Override
  public List<LoginRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.LoginRecordOper#modifyByLoginId(cn.skill6.common.entity.po.LoginRecord)
   */
  @Override
  public int modifyByLoginId(LoginRecord loginRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
