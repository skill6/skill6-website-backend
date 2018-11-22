package cn.skill6.website.service.basic.user;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.microservice.basic.uesr.UserSvc;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.intf.user.UserPrivacyInfoDao;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 用户服务实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月22日 上午12:47:25
 */
@Service
public class UserSvcImpl implements UserSvc {

  @Autowired private UserPrivacyInfoDao userPrivacyInfoDao;

  @Autowired private UserAdditionInfoDao userAdditionInfoDao;

  @Override
  public Long quickCreateUser(UserPrivacyInfo userPrivacyInfo) {
    Long userId = SequenceManager.getNextId();
    userPrivacyInfo.setUserId(userId);
    userPrivacyInfo.setUserName(createUserName());
    userPrivacyInfo.setUserType("100");
    userPrivacyInfo.setUserState(UserState.VALID);

    userPrivacyInfoDao.addUserPrivacyInfo(userPrivacyInfo);

    UserAdditionInfo userAdditionInfo = new UserAdditionInfo();
    userAdditionInfo.setUserId(userId);
    userAdditionInfo.setUserLastLoginTime(new Date());

    userAdditionInfoDao.addUserAdditionInfo(userAdditionInfo);

    return userId;
  }

  private String createUserName() {
    return StringUtils.join("用户", DateFormat.dateNumberFormat(), DateFormat.secondsTodayTotal());
  }
}
