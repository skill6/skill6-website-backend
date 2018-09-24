package cn.skill6.website.dao.impl.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.website.dao.intf.user.UserAdditionInfoOper;
import cn.skill6.website.dao.mappers.user.UserAdditionInfoMapper;

/**
 * 用户信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月28日 上午12:19:19
 */
public class UserAdditionInfoImpl implements UserAdditionInfoOper {
  private static final Logger logger = LoggerFactory.getLogger(UserAdditionInfoImpl.class);

  @Autowired private UserAdditionInfoMapper userAdditionInfoMapper;

  @Override
  public int deleteByUserId(Long userId) {
    logger.warn("删除id为{}的用户信息", userId);

    return userAdditionInfoMapper.deleteByPrimaryKey(userId);
  }

  @Override
  public int addUserInfo(UserAdditionInfo userAdditionInfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public UserAdditionInfo findByUserId(Long userId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserAdditionInfo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByUserId(UserAdditionInfo userAdditionInfo) {
    // TODO Auto-generated method stub
    return 0;
  }
}
