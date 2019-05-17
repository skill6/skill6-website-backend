package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserModifyRecord;
import java.util.List;

/**
 * 用户信息修改记录mapper
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:41:32
 */
public interface UserModifyRecordMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(UserModifyRecord userModifyRecord);

  UserModifyRecord selectByPrimaryKey(Long userId);

  List<UserModifyRecord> selectAll();

  int updateByPrimaryKey(UserModifyRecord userModifyRecord);
}
