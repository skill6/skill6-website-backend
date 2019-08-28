package cn.skill6.website.service.sign;

import cn.skill6.common.encrypt.Md5Encrypt;
import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.microservice.sign.SignUpSvc;
import cn.skill6.website.dao.impl.user.UserPrivacyInfoDaoImpl;
import cn.skill6.website.util.sequence.SequenceManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册服务实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月23日 下午10:24:15
 */
@Service
public class SignUpService implements SignUpSvc {

    @Autowired
    private UserPrivacyInfoDaoImpl userPrivacyInfoDao;

    @Override
    public String createUser(UserPrivacyInfo userPrivacyInfo) {
        // 密码加密
        encryptPassword(userPrivacyInfo);
        // 设置分布式用户id
        Long userId = SequenceManager.getNextId();
        if (userId != null) {
            userPrivacyInfo.setUserId(userId);
        } else {
            throw new NullPointerException("获取的userId为空");
        }

        // 设置正常状态
        userPrivacyInfo.setUserState(UserState.VALID);

        // 创建用户
        userPrivacyInfoDao.addUserPrivacyInfo(userPrivacyInfo);

        return userPrivacyInfo.getUserName();
    }

    /**
     * 密码加密
     *
     * @param userPrivacyInfo 用户信息
     */
    private void encryptPassword(UserPrivacyInfo userPrivacyInfo) {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        userPrivacyInfo.setUserPwdSalt(randomNumberGenerator.nextBytes().toHex());

        final int hashIterations = 2;
        String salt = StringUtils.join(userPrivacyInfo.getUserPwdSalt(), "@", userPrivacyInfo.getUserName());
        String encryptedPwd = Md5Encrypt.getMD5Code(userPrivacyInfo.getUserPassword(), salt, hashIterations);

        userPrivacyInfo.setUserPassword(encryptedPwd);
    }

}
