package cn.skill6.website.service.basic.user;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.microservice.basic.uesr.UserSvc;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.intf.user.UserPrivacyInfoDao;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月22日 上午12:47:25
 */
@Slf4j
@Service
public class UserSvcImpl implements UserSvc {

  @Resource(name = "userPrivacyInfoDaoOper")
  private UserPrivacyInfoDao userPrivacyInfoDao;

  @Resource(name = "userAdditionInfoDaoOper")
  private UserAdditionInfoDao userAdditionInfoDao;

  @Override
  public Long quickCreateUser(UserPrivacyInfo userPrivacyInfo) {
    Long userId = SequenceManager.getNextId();
    userPrivacyInfo.setUserId(userId);
    userPrivacyInfo.setUserName(createUserName());
    userPrivacyInfo.setUserPassword("password");
    userPrivacyInfo.setUserPwdSalt("salt");
    userPrivacyInfo.setUserType("100");

    userPrivacyInfoDao.addUserPrivacyInfo(userPrivacyInfo);

    UserAdditionInfo userAdditionInfo = new UserAdditionInfo();
    userAdditionInfo.setUserId(userId);
    userAdditionInfo.setUserLastLoginTime(new Date());

    userAdditionInfoDao.addUserAdditionInfo(userAdditionInfo);
    log.info("quickCreateUser, userAdditionInfo: {}", userAdditionInfo);

    return userId;
  }

  private String createUserName() {
    return StringUtils.join("用户", DateFormat.dateNumberFormat(), DateFormat.secondsTodayTotal());
  }
}
