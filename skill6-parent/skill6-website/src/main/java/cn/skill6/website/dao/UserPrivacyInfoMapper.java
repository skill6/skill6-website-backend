package cn.skill6.website.dao;

import cn.skill6.common.entity.po.UserPrivacyInfo;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户隐私信息mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:41:46
 */
@Mapper
public interface UserPrivacyInfoMapper {
  int deleteByUserId(Long userId);

  int insert(UserPrivacyInfo userPrivacyInfo);

  UserPrivacyInfo selectByPrimaryKey(Long userId);

  @Delete(
      "select user_id, user_name, user_email, user_phone, user_login_from, user_password, user_pwd_salt, user_type, user_state from user_privacy_info where user_phone = #{userPhone,jdbcType=VARCHAR}")
  UserPrivacyInfo selectByUserPhone(Long userPhone);

  List<UserPrivacyInfo> selectAll();

  int updateByPrimaryKey(UserPrivacyInfo userPrivacyInfo);
}
