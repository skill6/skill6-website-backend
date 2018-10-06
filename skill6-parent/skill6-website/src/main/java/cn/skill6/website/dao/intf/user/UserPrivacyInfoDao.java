package cn.skill6.website.dao.intf.user;

import java.util.List;

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
}
