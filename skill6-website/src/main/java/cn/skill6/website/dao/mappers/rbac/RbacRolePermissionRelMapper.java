package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRolePermissionRel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 角色-权限关联mapper
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午10:26:17
 */
public interface RbacRolePermissionRelMapper {
  int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

  int insert(RbacRolePermissionRel rbacRolePermissionRel);

  List<RbacRolePermissionRel> selectAll();
}
