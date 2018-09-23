package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacUserRoleRel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacUserRoleRelMapper {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(RbacUserRoleRel record);

    List<RbacUserRoleRel> selectAll();
}