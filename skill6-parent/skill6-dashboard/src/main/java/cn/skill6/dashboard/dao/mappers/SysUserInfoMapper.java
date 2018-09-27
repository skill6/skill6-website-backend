package cn.skill6.dashboard.dao.mappers;

import cn.skill6.dashboard.model.po.SysUserInfo;
import java.util.List;

/**
 * 系统用户信息操作接口
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月27日 下午11:19:05
 */
public interface SysUserInfoMapper {
  int deleteByPrimaryKey(Long userId);

  int insert(SysUserInfo sysUserInfo);

  SysUserInfo selectByPrimaryKey(Long userId);

  List<SysUserInfo> selectAll();

  int updateByPrimaryKey(SysUserInfo sysUserInfo);
}
