package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import java.util.List;

public interface RbacRoleInfoMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(RbacRoleInfo record);

    RbacRoleInfo selectByPrimaryKey(Long roleId);

    List<RbacRoleInfo> selectAll();

    int updateByPrimaryKey(RbacRoleInfo record);
}