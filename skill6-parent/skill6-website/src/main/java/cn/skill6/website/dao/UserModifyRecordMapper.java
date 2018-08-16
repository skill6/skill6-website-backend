package cn.skill6.website.dao;

import cn.skill6.common.entity.po.UserModifyRecord;
import java.util.List;

/**
 * 用户信息修改记录mapper
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:41:32
 * @version 1.0.0
 */
public interface UserModifyRecordMapper {
  int deleteByPrimaryKey(String userId);

  int insert(UserModifyRecord record);

  UserModifyRecord selectByPrimaryKey(String userId);

  List<UserModifyRecord> selectAll();

  int updateByPrimaryKey(UserModifyRecord record);
}
