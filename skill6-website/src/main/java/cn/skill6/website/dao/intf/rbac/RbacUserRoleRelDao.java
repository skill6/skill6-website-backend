package cn.skill6.website.dao.intf.rbac;

import cn.skill6.common.entity.po.rbac.RbacUserRoleRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户-角色关联操作接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午10:49:11
 */
public interface RbacUserRoleRelDao {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int addRbacUserRoleRel(RbacUserRoleRel rbacUserRoleRel);

    List<RbacUserRoleRel> findAll();
}
