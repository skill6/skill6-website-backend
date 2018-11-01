package cn.skill6.common.entity.po.rbac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RBAC角色-权限关联
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年9月23日 下午5:53:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacRolePermissionRel {

  private Long roleId;

  private Long permissionId;
}
