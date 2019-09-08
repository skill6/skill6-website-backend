package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacUserRoleRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户-角色关联mapper
 *
 * @author 何明胜
 * @since 2018年9月23日 下午10:27:16
 */
@Repository
public interface RbacUserRoleRelMapper {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(RbacUserRoleRel rbacUserRoleRel);

    List<RbacUserRoleRel> selectAll();
}
