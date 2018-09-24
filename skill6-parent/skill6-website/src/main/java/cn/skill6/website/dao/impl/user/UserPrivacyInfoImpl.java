package cn.skill6.website.dao.impl.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.website.dao.intf.user.UserPrivacyInfoOper;
import cn.skill6.website.dao.mappers.user.UserPrivacyInfoMapper;

/**
 * 用户隐私信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月28日 上午12:19:56
 */
public class UserPrivacyInfoImpl implements UserPrivacyInfoOper {
  private static final Logger logger = LoggerFactory.getLogger(UserPrivacyInfoImpl.class);

  @Autowired private UserPrivacyInfoMapper userPrivacyInfoMapper;

  @Override
  public int deleteByUserId(Long userId) {
    logger.warn("删除id为{}的用户隐私信息", userId);

    return userPrivacyInfoMapper.deleteByPrimaryKey(userId);
  }

  @Override
  public int addUserPrivacyInfo(UserPrivacyInfo userPrivacyInfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public UserPrivacyInfo findByUserId(Long userId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserPrivacyInfo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByUserId(UserPrivacyInfo userPrivacyInfo) {
    // TODO Auto-generated method stub
    return 0;
  }
}
