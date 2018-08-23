package cn.skill6.service.intf.basic;

import java.util.List;

import cn.skill6.common.entity.po.UserModifyRecord;

/**
 * 用户修改记录操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:30:23
 */
public interface UserModifyRecordOper {
  int deleteByUserId(String userId);

  int addUserModifyRecord(UserModifyRecord userModifyRecord);

  UserModifyRecord findByUserId(String userId);

  List<UserModifyRecord> findAll();

  int modifyByUserId(UserModifyRecord userModifyRecord);
}
