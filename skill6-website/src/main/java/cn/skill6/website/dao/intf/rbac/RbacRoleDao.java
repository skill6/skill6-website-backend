package cn.skill6.website.dao.intf.rbac;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
import cn.skill6.common.entity.po.rbac.RbacRoleInfo;

import java.util.List;

/**
 * 角色信息操作接口
 *
 * @author 何明胜
 * @since 2018年9月23日 下午10:46:43
 */
public interface RbacRoleDao {
    int deleteByRoleId(Long roleId);

    int addRbacRoleInfo(RbacRoleInfo rbacRoleInfo);

    RbacRoleInfo findByPrimaryKey(Long roleId);

    List<RbacRoleInfo> findAll();

    int modifyByRoleId(RbacRoleInfo rbacRoleInfo);

    /**
     * 根据角色id查找对应权限
     */
    List<RbacPermissionInfo> findPermissionByRoleIds(List<Long> roleIds);
}
