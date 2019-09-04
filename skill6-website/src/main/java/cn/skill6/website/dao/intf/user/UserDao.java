package cn.skill6.website.dao.intf.user;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.common.entity.po.user.UserInfo;

import java.util.List;

/**
 * 用户隐私信息接口
 *
 * @author 何明胜
 * @since 2018年8月24日 上午12:30:56
 */
public interface UserDao {
    int deleteByUserId(Long userId);

    void addUserPrivacyInfo(UserInfo userPrivacyInfo);

    UserInfo findByUserId(Long userId);

    List<UserInfo> findAll();

    void modifyByUserId(UserInfo userPrivacyInfo);

    /**
     * 根据用户名查找用户
     */
    UserInfo findUserByUserName(String userName);

    /**
     * 根据用户手机号查找用户
     */
    UserInfo findUserByUserPhone(String userPhone);

    /**
     * 根据用户邮箱查找用户
     */
    UserInfo findUserByUserEmail(String userEmail);

    /**
     * 根据用户名查找角色集合
     */
    List<RbacRoleInfo> findRolesByUserName(String userName);

    /**
     * 根据用户手机号查找角色集合
     */
    List<RbacRoleInfo> findRolesByUserPhone(String userPhone);

    /**
     * 根据用户邮箱查找角色集合
     */
    List<RbacRoleInfo> findRolesByUserEmail(String userEmail);
}
