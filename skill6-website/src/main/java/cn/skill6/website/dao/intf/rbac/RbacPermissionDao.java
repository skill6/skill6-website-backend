package cn.skill6.website.dao.intf.rbac;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;

import java.util.List;

/**
 * 权限信息操作接口
 *
 * @author 何明胜
 * @since 2018年9月23日 下午10:39:58
 */
public interface RbacPermissionDao {
    int deleteByPermissionId(Long permissionId);

    int addRbacPermissionInfo(RbacPermissionInfo rbacPermissionInfo);

    RbacPermissionInfo findByPrimaryKey(Long permissionId);

    List<RbacPermissionInfo> findAll();

    int modifyByPermissionId(RbacPermissionInfo rbacPermissionInfo);
}
