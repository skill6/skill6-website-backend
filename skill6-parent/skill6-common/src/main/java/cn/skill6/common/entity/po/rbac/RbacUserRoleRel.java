package cn.skill6.common.entity.po.rbac;

/**
 * RBAC用户角色关联
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月23日 下午5:53:33
 */
public class RbacUserRoleRel {
  private Long userId;

  private Long roleId;

  @Override
  public String toString() {
    return "RbacUserRoleRel [userId=" + userId + ", roleId=" + roleId + "]";
  }

  public RbacUserRoleRel(Long userId, Long roleId) {
    this.userId = userId;
    this.roleId = roleId;
  }

  public RbacUserRoleRel() {
    super();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }
}
