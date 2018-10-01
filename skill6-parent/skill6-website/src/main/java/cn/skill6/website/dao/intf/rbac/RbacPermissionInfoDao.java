package cn.skill6.website.dao.intf.rbac;

import java.util.List;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;

/**
 * 权限信息操作接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午10:39:58
 */
public interface RbacPermissionInfoDao {
  int deleteByPermissionId(Long permissionId);

  int addRbacPermissionInfo(RbacPermissionInfo rbacPermissionInfo);

  RbacPermissionInfo findByPrimaryKey(Long permissionId);

  List<RbacPermissionInfo> findAll();

  int modifyByPermissionId(RbacPermissionInfo rbacPermissionInfo);
}
