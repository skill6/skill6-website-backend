package cn.skill6.website.service.basic.user;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.microservice.basic.uesr.UserSvc;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.intf.user.UserInfoDao;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户服务实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月22日 上午12:47:25
 */
@Slf4j
@Service
public class UserService implements UserSvc {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserAdditionInfoDao userAdditionInfoDao;

    @Override
    public Long quickCreateUser(UserInfo userInfo) {
        Long userId = SequenceManager.getNextId();
        userInfo.setUserId(userId);
        userInfo.setUserName(createUserName());
        userInfo.setUserPassword("password");
        userInfo.setUserPwdSalt("salt");
        userInfo.setUserType("100");

        userInfoDao.addUserPrivacyInfo(userInfo);

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
