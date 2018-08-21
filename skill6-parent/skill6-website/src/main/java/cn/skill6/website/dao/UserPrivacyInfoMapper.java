package cn.skill6.website.dao;

import cn.skill6.common.entity.po.UserPrivacyInfo;
import java.util.List;

/**
 * 用户隐私信息mapper
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:41:46
 */
public interface UserPrivacyInfoMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(UserPrivacyInfo record);

  UserPrivacyInfo selectByPrimaryKey(Long userId);

  List<UserPrivacyInfo> selectAll();

  int updateByPrimaryKey(UserPrivacyInfo record);
}
