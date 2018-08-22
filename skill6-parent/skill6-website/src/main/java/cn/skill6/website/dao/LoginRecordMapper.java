package cn.skill6.website.dao;

import cn.skill6.common.entity.po.LoginRecord;
import java.util.List;

/**
 * 登录记录mapper
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:40:54
 */
public interface LoginRecordMapper {
  int deleteByPrimaryKey(Long loginId);

  int insert(LoginRecord record);

  LoginRecord selectByPrimaryKey(Long loginId);

  List<LoginRecord> selectAll();

  int updateByPrimaryKey(LoginRecord record);
}
