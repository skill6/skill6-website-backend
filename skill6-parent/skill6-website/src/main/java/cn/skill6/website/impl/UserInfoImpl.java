package cn.skill6.website.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.UserInfo;
import cn.skill6.service.intf.basic.UserInfoOper;
import cn.skill6.website.dao.UserInfoMapper;

/**
 * 用户信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:19:19
 */
public class UserInfoImpl implements UserInfoOper {
  private static final Logger logger = LoggerFactory.getLogger(UserInfoImpl.class);

  @Autowired private UserInfoMapper userInfoMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserInfoOper#deleteByUserId(java.lang.Long)
   */
  @Override
  public int deleteByUserId(Long userId) {
    logger.warn("删除id为{}的用户信息", userId);

    return userInfoMapper.deleteByPrimaryKey(userId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserInfoOper#addUserInfo(cn.skill6.common.entity.po.UserInfo)
   */
  @Override
  public int addUserInfo(UserInfo userInfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserInfoOper#findByUserId(java.lang.Long)
   */
  @Override
  public UserInfo findByUserId(Long userId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserInfoOper#findAll()
   */
  @Override
  public List<UserInfo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.UserInfoOper#modifyByUserId(cn.skill6.common.entity.po.UserInfo)
   */
  @Override
  public int modifyByUserId(UserInfo userInfo) {
    // TODO Auto-generated method stub
    return 0;
  }
}
