package cn.skill6.website.dao.impl.user;

import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.user.UserDao;
import cn.skill6.website.dao.mappers.user.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户隐私信息操作实现类
 *
 * @author 何明胜
 * @since 2018年8月28日 上午12:19:56
 */
@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByUserId(Long userId) {
        log.warn("删除id为{}的用户隐私信息", userId);

        return userInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void addUserPrivacyInfo(UserInfo userInfo) {
        if (userInfo.getUserName() == null) {
            throw new NullPointerException("用户名不能为null");
        }
        if (userInfo.getUserLoginFrom() == null) {
            throw new NullPointerException("用户首次登陆方式不能为null");
        }
        if (userInfo.getUserPassword() == null) {
            throw new NullPointerException("用户密码不能为null");
        }
        if (userInfo.getUserPwdSalt() == null) {
            throw new NullPointerException("用户密码盐不能为null");
        }
        // TODO - 后期去掉用户类型，普通用户和管理用户已经分离
        if (userInfo.getUserType() == null) {
            throw new NullPointerException("用户类型不能为null");
        }

        Long userId = userInfo.getUserId();
        if (userId == null) {
            throw new NullPointerException("用户id不能为空");
        }
        userInfo.setUserState(UserState.VALID);

        userInfoMapper.insert(userInfo);
    }

    @Override
    public UserInfo findByUserId(Long userId) {
        if (userId == null) {
            throw new NullPointerException("用户id不能为空");
        }

        UserInfo userPrivacyInfo = userInfoMapper.selectByPrimaryKey(userId);
        log.info("找到id为{}的用户主要信息,{}", userId, userPrivacyInfo);

        return userPrivacyInfo;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userPrivacyInfos = userInfoMapper.selectAll();
        log.info("找到所有用户隐私信息");

        return userPrivacyInfos;
    }

    @Override
    public void modifyByUserId(UserInfo userInfo) {
        if (userInfo.getUserId() == null) {
            throw new NullPointerException("用户id不能为空");
        }

        if (userInfo.getUserName() == null) {
            throw new NullPointerException("用户名不能为null");
        }
        if (userInfo.getUserLoginFrom() == null) {
            throw new NullPointerException("用户首次登陆方式不能为null");
        }
        if (userInfo.getUserPassword() == null) {
            throw new NullPointerException("用户密码不能为null");
        }
        if (userInfo.getUserPwdSalt() == null) {
            throw new NullPointerException("用户密码盐不能为null");
        }
        // TODO - 后期去掉用户类型，普通用户和管理用户已经分离
        if (userInfo.getUserType() == null) {
            throw new NullPointerException("用户类型不能为null");
        }

        userInfoMapper.updateByPrimaryKey(userInfo);
        log.info("成功修改id为{}的用户隐私信息", userInfo.getUserId());
    }

    @Override
    public List<RbacRoleInfo> findRolesByUserName(String userName) {
        return null;
    }

    @Override
    public List<RbacRoleInfo> findRolesByUserPhone(String userPhone) {
        return null;
    }

    @Override
    public List<RbacRoleInfo> findRolesByUserEmail(String userEmail) {
        return null;
    }

    @Override
    public UserInfo findUserByUserName(String userName) {
        return userInfoMapper.selectByUserName(userName);
    }

    @Override
    public UserInfo findUserByUserPhone(String userPhone) {
        return null;
    }

    @Override
    public UserInfo findUserByUserEmail(String userEmail) {
        return null;
    }
}
