package cn.skill6.website.service.sign;

import cn.skill6.common.encrypt.Md5Encrypt;
import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.intf.user.UserDao;
import cn.skill6.website.sign.SignUpSvc;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 注册服务实现
 *
 * @author 何明胜
 * @since 2018年11月23日 下午10:24:15
 */
@Slf4j
@Service
public class SignUpService implements SignUpSvc {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAdditionInfoDao userAdditionInfoDao;

    @Override
    public String createUser(UserInfo userInfo) {
        // 密码加密
        encryptPassword(userInfo);
        // 设置分布式用户id
        Long userId = SequenceManager.getNextId();
        if (userId != null) {
            userInfo.setUserId(userId);
        } else {
            throw new NullPointerException("获取的userId为空");
        }

        // 设置正常状态
        userInfo.setUserState(UserState.VALID);

        // 创建用户
        userDao.addUserPrivacyInfo(userInfo);

        return userInfo.getUserName();
    }

    @Override
    public long quickCreateUser(UserInfo userInfo) {
        Long userId = SequenceManager.getNextId();
        userInfo.setUserId(userId);
        userInfo.setUserName(createUserName());
        userInfo.setUserPassword("password");
        userInfo.setUserPwdSalt("salt");
        userInfo.setUserType("100");

        userDao.addUserPrivacyInfo(userInfo);

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

    /**
     * 密码加密
     *
     * @param userInfo 用户信息
     */
    private void encryptPassword(UserInfo userInfo) {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        userInfo.setUserPwdSalt(randomNumberGenerator.nextBytes().toHex());

        final int hashIterations = 2;
        String salt = StringUtils.join(userInfo.getUserPwdSalt(), "@", userInfo.getUserName());
        String encryptedPwd = Md5Encrypt.getMD5Code(userInfo.getUserPassword(), salt, hashIterations);

        userInfo.setUserPassword(encryptedPwd);
    }

}
