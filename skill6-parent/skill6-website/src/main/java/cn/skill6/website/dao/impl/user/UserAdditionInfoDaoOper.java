package cn.skill6.website.dao.impl.user;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.common.utility.RandomCode;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.mappers.user.UserAdditionInfoMapper;

/**
 * 用户信息操作实现类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月28日 上午12:19:19
 */
public class UserAdditionInfoDaoOper implements UserAdditionInfoDao {
  private static final Logger logger = LoggerFactory.getLogger(UserAdditionInfoDaoOper.class);

  @Autowired private UserAdditionInfoMapper userAdditionInfoMapper;

  @Override
  public int deleteByUserId(Long userId) {
    logger.warn("删除id为{}的用户信息", userId);

    return userAdditionInfoMapper.deleteByPrimaryKey(userId);
  }

  @Override
  public void addUserAdditionInfo(UserAdditionInfo userAdditionInfo) {
    if (userAdditionInfo.getUserId() == null) {
      throw new NullPointerException("用户id不能为null");
    }

    if (userAdditionInfo.getUserNickName() == null) {
      userAdditionInfo.setUserNickName("用户" + RandomCode.producedRandomCodeStr6());
    }
    userAdditionInfo.setUserRegisterTime(new Date());
  }

  @Override
  public UserAdditionInfo findByUserId(Long userId) {
    UserAdditionInfo userAdditionInfo = userAdditionInfoMapper.selectByPrimaryKey(userId);
    logger.info("找到id为{}的用户其他信息,{}", userId, userAdditionInfo);

    return userAdditionInfo;
  }

  @Override
  public List<UserAdditionInfo> findAll() {
    List<UserAdditionInfo> userAdditionInfos = userAdditionInfoMapper.selectAll();
    logger.info("找到所有用户额外信息,{}", userAdditionInfos);

    return userAdditionInfos;
  }

  @Override
  public void modifyByUserId(UserAdditionInfo userAdditionInfo) {
    if (userAdditionInfo.getUserId() == null) {
      throw new NullPointerException("用户id不能为null");
    }

    userAdditionInfoMapper.updateByPrimaryKey(userAdditionInfo);
    logger.info("成功修改id为{}的用户额外信息", userAdditionInfo.getUserId());
  }
}
