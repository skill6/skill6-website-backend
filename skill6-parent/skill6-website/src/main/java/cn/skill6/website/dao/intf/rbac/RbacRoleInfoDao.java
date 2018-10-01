package cn.skill6.website.dao.intf.rbac;

import java.util.List;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;

/**
 * 角色信息操作接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午10:46:43
 */
public interface RbacRoleInfoDao {
  int deleteByRoleId(Long roleId);

  int addRbacRoleInfo(RbacRoleInfo rbacRoleInfo);

  RbacRoleInfo findByPrimaryKey(Long roleId);

  List<RbacRoleInfo> findAll();

  int modifyByRoleId(RbacRoleInfo rbacRoleInfo);
}
