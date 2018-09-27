package cn.skill6.dashboard.dao.mappers;

import cn.skill6.dashboard.model.po.SysPermissionInfo;
import java.util.List;

/**
 * 系统权限信息操作接口
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月27日 下午11:17:52
 */
public interface SysPermissionInfoMapper {
  int deleteByPrimaryKey(Long permissionId);

  int insert(SysPermissionInfo sysPermissionInfo);

  SysPermissionInfo selectByPrimaryKey(Long permissionId);

  List<SysPermissionInfo> selectAll();

  int updateByPrimaryKey(SysPermissionInfo sysPermissionInfo);
}
