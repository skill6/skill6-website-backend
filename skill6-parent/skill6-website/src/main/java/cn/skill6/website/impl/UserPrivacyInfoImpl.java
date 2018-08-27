package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.UserPrivacyInfo;
import cn.skill6.service.intf.basic.UserPrivacyInfoOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:19:56
 */
public class UserPrivacyInfoImpl implements UserPrivacyInfoOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserPrivacyInfoOper#deleteByUserId(java.lang.Long)
   */
  @Override
  public int deleteByUserId(Long userId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserPrivacyInfoOper#addUserPrivacyInfo(cn.skill6.common.entity.po.UserPrivacyInfo)
   */
  @Override
  public int addUserPrivacyInfo(UserPrivacyInfo userPrivacyInfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserPrivacyInfoOper#findByUserId(java.lang.Long)
   */
  @Override
  public UserPrivacyInfo findByUserId(Long userId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserPrivacyInfoOper#findAll()
   */
  @Override
  public List<UserPrivacyInfo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserPrivacyInfoOper#modifyByUserId(cn.skill6.common.entity.po.UserPrivacyInfo)
   */
  @Override
  public int modifyByUserId(UserPrivacyInfo userPrivacyInfo) {
    // TODO Auto-generated method stub
    return 0;
  }
}
