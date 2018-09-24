package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import java.util.List;

/**
 * 用户附加信息mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:41:20
 */
public interface UserAdditionInfoMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(UserAdditionInfo userAdditionInfo);

  UserAdditionInfo selectByPrimaryKey(Long userId);

  List<UserAdditionInfo> selectAll();

  int updateByPrimaryKey(UserAdditionInfo userAdditionInfo);
}
