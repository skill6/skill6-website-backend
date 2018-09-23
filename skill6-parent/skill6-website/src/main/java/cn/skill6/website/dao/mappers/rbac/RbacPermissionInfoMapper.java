package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
import java.util.List;

public interface RbacPermissionInfoMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(RbacPermissionInfo record);

    RbacPermissionInfo selectByPrimaryKey(Long permissionId);

    List<RbacPermissionInfo> selectAll();

    int updateByPrimaryKey(RbacPermissionInfo record);
}