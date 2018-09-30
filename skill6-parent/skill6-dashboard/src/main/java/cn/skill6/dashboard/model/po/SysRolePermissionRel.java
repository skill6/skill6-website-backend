package cn.skill6.dashboard.model.po;

/**
 * 系统角色权限关联实体类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月27日 下午11:20:25
 */
public class SysRolePermissionRel {
  private Long roleId;

  private Long permissionId;

  public SysRolePermissionRel(Long roleId, Long permissionId) {
    this.roleId = roleId;
    this.permissionId = permissionId;
  }

  public SysRolePermissionRel() {
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
