package cn.skill6.website.dao.impl.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.user.UserPrivacyInfoDao;
import cn.skill6.website.dao.mappers.user.UserPrivacyInfoMapper;

/**
 * 用户隐私信息操作实现类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月28日 上午12:19:56
 */
public class UserPrivacyInfoDaoOper implements UserPrivacyInfoDao {
  private static final Logger logger = LoggerFactory.getLogger(UserPrivacyInfoDaoOper.class);

  @Autowired private UserPrivacyInfoMapper userPrivacyInfoMapper;

  @Override
  public int deleteByUserId(Long userId) {
    logger.warn("删除id为{}的用户隐私信息", userId);

    return userPrivacyInfoMapper.deleteByPrimaryKey(userId);
  }

  @Override
  public void addUserPrivacyInfo(UserPrivacyInfo userPrivacyInfo) {
    if (userPrivacyInfo.getUserName() == null) {
      throw new NullPointerException("用户名不能为null");
    }
    if (userPrivacyInfo.getUserLoginFrom() == null) {
      throw new NullPointerException("用户首次登陆方式不能为null");
    }
    if (userPrivacyInfo.getUserPassword() == null) {
      throw new NullPointerException("用户密码不能为null");
    }
    if (userPrivacyInfo.getUserPwdSalt() == null) {
      throw new NullPointerException("用户密码盐不能为null");
    }
    // TODO - 后期去掉用户类型，普通用户和管理用户已经分离
    if (userPrivacyInfo.getUserType() == null) {
      throw new NullPointerException("用户类型不能为null");
    }

    Long userId = userPrivacyInfo.getUserId();
    if (userId == null) {
      throw new NullPointerException("用户id不能为空");
    }
    // TODO - 增加用户状态枚举
    userPrivacyInfo.setUserState("100");
  }

  @Override
  public UserPrivacyInfo findByUserId(Long userId) {
    if (userId == null) {
      throw new NullPointerException("用户id不能为空");
    }

    UserPrivacyInfo userPrivacyInfo = userPrivacyInfoMapper.selectByPrimaryKey(userId);
    logger.info("找到id为{}的用户主要信息,{}", userId, userPrivacyInfo);

    return userPrivacyInfo;
  }

  @Override
  public List<UserPrivacyInfo> findAll() {
    List<UserPrivacyInfo> userPrivacyInfos = userPrivacyInfoMapper.selectAll();
    logger.info("找到所有用户隐私信息");

    return userPrivacyInfos;
  }

  @Override
  public void modifyByUserId(UserPrivacyInfo userPrivacyInfo) {
    if (userPrivacyInfo.getUserId() == null) {
      throw new NullPointerException("用户id不能为空");
    }

    if (userPrivacyInfo.getUserName() == null) {
      throw new NullPointerException("用户名不能为null");
    }
    if (userPrivacyInfo.getUserLoginFrom() == null) {
      throw new NullPointerException("用户首次登陆方式不能为null");
    }
    if (userPrivacyInfo.getUserPassword() == null) {
      throw new NullPointerException("用户密码不能为null");
    }
    if (userPrivacyInfo.getUserPwdSalt() == null) {
      throw new NullPointerException("用户密码盐不能为null");
    }
    // TODO - 后期去掉用户类型，普通用户和管理用户已经分离
    if (userPrivacyInfo.getUserType() == null) {
      throw new NullPointerException("用户类型不能为null");
    }

    userPrivacyInfoMapper.updateByPrimaryKey(userPrivacyInfo);
    logger.info("成功修改id为{}的用户隐私信息");
  }
}
