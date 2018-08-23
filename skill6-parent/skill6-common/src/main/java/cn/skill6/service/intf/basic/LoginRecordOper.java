package cn.skill6.service.intf.basic;

import java.util.List;

import cn.skill6.common.entity.po.LoginRecord;

/**
 * 登录记录操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:29:04
 */
public interface LoginRecordOper {
  int deleteByLoginId(Long loginId);

  int addLoginRecord(LoginRecord loginRecord);

  LoginRecord findByLoginId(Long loginId);

  List<LoginRecord> findAll();

  int modifyByLoginId(LoginRecord loginRecord);
}
