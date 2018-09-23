package cn.skill6.common.entity.po.rbac;

/**
 * RBAC角色-权限关联
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月23日 下午5:53:04
 */
public class RbacRolePermissionRel {
  private Long roleId;

  private Long permissionId;

  @Override
  public String toString() {
    return "RbacRolePermissionRel [roleId=" + roleId + ", permissionId=" + permissionId + "]";
  }

  public RbacRolePermissionRel(Long roleId, Long permissionId) {
    this.roleId = roleId;
    this.permissionId = permissionId;
  }

  public RbacRolePermissionRel() {
    super();
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
  }
}
