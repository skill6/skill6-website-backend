package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
import java.util.List;

/**
 * 权限信息mapper
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午10:25:04
 */
public interface RbacPermissionInfoMapper {
  int deleteByPrimaryKey(Long permissionId);

  int insert(RbacPermissionInfo rbacPermissionInfo);

  RbacPermissionInfo selectByPrimaryKey(Long permissionId);

  List<RbacPermissionInfo> selectAll();

  int updateByPrimaryKey(RbacPermissionInfo rbacPermissionInfo);
}
