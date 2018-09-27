package cn.skill6.dashboard.model.po;

/**
 * 系统用户-角色关联实体类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月27日 下午11:20:55
 */
public class SysUserRoleRel {
  private Long userId;

  private Long roleId;

  public SysUserRoleRel(Long userId, Long roleId) {
    this.userId = userId;
    this.roleId = roleId;
  }

  public SysUserRoleRel() {
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
