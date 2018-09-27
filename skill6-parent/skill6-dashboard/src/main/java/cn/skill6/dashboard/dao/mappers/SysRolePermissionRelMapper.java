package cn.skill6.dashboard.dao.mappers;

import cn.skill6.dashboard.model.po.SysRolePermissionRel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 系统角色-权限关联操作接口
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月27日 下午11:18:39
 */
public interface SysRolePermissionRelMapper {
  int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

  int insert(SysRolePermissionRel sysRolePermissionRel);

  List<SysRolePermissionRel> selectAll();
}
