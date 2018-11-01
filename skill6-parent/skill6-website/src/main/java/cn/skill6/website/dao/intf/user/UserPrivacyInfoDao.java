package cn.skill6.website.dao.intf.user;

import java.util.List;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;

/**
 * 用户隐私信息接口
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月24日 上午12:30:56
 */
public interface UserPrivacyInfoDao {
  int deleteByUserId(Long userId);

  void addUserPrivacyInfo(UserPrivacyInfo userPrivacyInfo);

  UserPrivacyInfo findByUserId(Long userId);

  List<UserPrivacyInfo> findAll();

  void modifyByUserId(UserPrivacyInfo userPrivacyInfo);

  /** 根据用户名查找用户 */
  UserPrivacyInfo findUserByUserName(String userName);

  /** 根据用户手机号查找用户 */
  UserPrivacyInfo findUserByUserPhone(String userPhone);

  /** 根据用户邮箱查找用户 */
  UserPrivacyInfo findUserByUserEmail(String userEmail);

  /** 根据用户名查找角色集合 */
  List<RbacRoleInfo> findRolesByUserName(String userName);

  /** 根据用户手机号查找角色集合 */
  List<RbacRoleInfo> findRolesByUserPhone(String userPhone);

  /** 根据用户邮箱查找角色集合 */
  List<RbacRoleInfo> findRolesByUserEmail(String userEmail);
}
