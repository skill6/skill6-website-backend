package cn.skill6.website.dao.mappers.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.skill6.common.entity.po.user.UserPrivacyInfo;

/**
 * 用户隐私信息mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:41:46
 */
@Mapper
public interface UserPrivacyInfoMapper {

  int deleteByPrimaryKey(Long userId);

  int insert(UserPrivacyInfo userPrivacyInfo);

  UserPrivacyInfo selectByPrimaryKey(Long userId);

  List<UserPrivacyInfo> selectAll();

  int updateByPrimaryKey(UserPrivacyInfo userPrivacyInfo);
}
