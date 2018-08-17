package cn.skill6.website.dao;

import cn.skill6.common.entity.po.UserInfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户公共信息mapper
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:41:20
 * @version 1.0.0
 */
@Mapper
public interface UserInfoMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(UserInfo record);

  UserInfo selectByPrimaryKey(Long userId);

  List<UserInfo> selectAll();

  int updateByPrimaryKey(UserInfo record);
}