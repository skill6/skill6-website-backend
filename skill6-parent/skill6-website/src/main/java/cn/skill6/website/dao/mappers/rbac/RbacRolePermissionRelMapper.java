package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRolePermissionRel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacRolePermissionRelMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RbacRolePermissionRel record);

    List<RbacRolePermissionRel> selectAll();
}