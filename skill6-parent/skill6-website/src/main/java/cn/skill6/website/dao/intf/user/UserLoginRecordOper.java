package cn.skill6.website.dao.intf.user;

import java.util.List;

import cn.skill6.common.entity.po.user.UserLoginRecord;

/**
 * 登录记录操作接口
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月24日 上午12:29:04
 */
public interface UserLoginRecordOper {
  int deleteByLoginId(Long loginId);

  int addLoginRecord(UserLoginRecord userLoginRecord);

  UserLoginRecord findByLoginId(Long loginId);

  List<UserLoginRecord> findAll();

  int modifyByLoginId(UserLoginRecord userLoginRecord);
}
