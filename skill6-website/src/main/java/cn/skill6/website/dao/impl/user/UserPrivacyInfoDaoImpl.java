package cn.skill6.website.dao.impl.user;

import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.user.UserPrivacyInfoDao;
import cn.skill6.website.dao.mappers.user.UserPrivacyInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户隐私信息操作实现类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月28日 上午12:19:56
 */
@Slf4j
@Repository
public class UserPrivacyInfoDaoImpl implements UserPrivacyInfoDao {

    @Autowired
    private UserPrivacyInfoMapper userPrivacyInfoMapper;

    @Override
    public int deleteByUserId(Long userId) {
        log.warn("删除id为{}的用户隐私信息", userId);

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
        userPrivacyInfo.setUserState(UserState.VALID);

        userPrivacyInfoMapper.insert(userPrivacyInfo);
    }

    @Override
    public UserPrivacyInfo findByUserId(Long userId) {
        if (userId == null) {
            throw new NullPointerException("用户id不能为空");
        }

        UserPrivacyInfo userPrivacyInfo = userPrivacyInfoMapper.selectByPrimaryKey(userId);
        log.info("找到id为{}的用户主要信息,{}", userId, userPrivacyInfo);

        return userPrivacyInfo;
    }

    @Override
    public List<UserPrivacyInfo> findAll() {
        List<UserPrivacyInfo> userPrivacyInfos = userPrivacyInfoMapper.selectAll();
        log.info("找到所有用户隐私信息");

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
        log.info("成功修改id为{}的用户隐私信息");
    }

    @Override
    public List<RbacRoleInfo> findRolesByUserName(
            String userName) { // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RbacRoleInfo> findRolesByUserPhone(
            String userPhone) { // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RbacRoleInfo> findRolesByUserEmail(
            String userEmail) { // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserPrivacyInfo findUserByUserName(String userName) {
        return userPrivacyInfoMapper.selectByUserName(userName);
    }

    @Override
    public UserPrivacyInfo findUserByUserPhone(String userPhone) { // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserPrivacyInfo findUserByUserEmail(String userEmail) { // TODO Auto-generated method stub
        return null;
    }
}
