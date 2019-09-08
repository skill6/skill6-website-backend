package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRolePermissionRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色-权限关联mapper
 *
 * @author 何明胜
 * @since 2018年9月23日 下午10:26:17
 */
@Repository
public interface RbacRolePermissionRelMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RbacRolePermissionRel rbacRolePermissionRel);

    List<RbacRolePermissionRel> selectAll();
}
