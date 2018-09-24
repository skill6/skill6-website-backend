package cn.skill6.website.dao.intf.rbac;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.skill6.common.entity.po.rbac.RbacRolePermissionRel;

/**
 * 角色-权限关联操作接口
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月23日 下午10:47:27
 */
public interface RbacRolePermissionRelDao {
  int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

  int addRbacRolePermissionRel(RbacRolePermissionRel rbacRolePermissionRel);

  List<RbacRolePermissionRel> findAll();
}
