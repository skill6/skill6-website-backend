package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.UserInfo;

/**
 * 用户信息操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:30:09
 */
public interface UserInfoOper {
  int deleteByUserId(Long userId);

  int addUserInfo(UserInfo userInfo);

  UserInfo findByUserId(Long userId);

  List<UserInfo> findAll();

  int modifyByUserId(UserInfo userInfo);
}
