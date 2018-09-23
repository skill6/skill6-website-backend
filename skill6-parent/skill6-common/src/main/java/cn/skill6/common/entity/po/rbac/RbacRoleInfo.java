package cn.skill6.common.entity.po.rbac;

import java.util.Date;

/**
 * RBAC角色信息
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月23日 下午5:52:52
 */
public class RbacRoleInfo {
  private Long roleId;

  private String roleName;

  private String roleCode;

  private String roleDesc;

  private Date roleCreateTime;

  private Date roleLastModifyTime;

  private Boolean roleValid;

  public RbacRoleInfo(
      Long roleId,
      String roleName,
      String roleCode,
      String roleDesc,
      Date roleCreateTime,
      Date roleLastModifyTime,
      Boolean roleValid) {
    this.roleId = roleId;
    this.roleName = roleName;
    this.roleCode = roleCode;
    this.roleDesc = roleDesc;
    this.roleCreateTime = roleCreateTime;
    this.roleLastModifyTime = roleLastModifyTime;
    this.roleValid = roleValid;
  }

  public RbacRoleInfo() {
    super();
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName == null ? null : roleName.trim();
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode == null ? null : roleCode.trim();
  }

  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc == null ? null : roleDesc.trim();
  }

  public Date getRoleCreateTime() {
    return roleCreateTime;
  }

  public void setRoleCreateTime(Date roleCreateTime) {
    this.roleCreateTime = roleCreateTime;
  }

  public Date getRoleLastModifyTime() {
    return roleLastModifyTime;
  }

  public void setRoleLastModifyTime(Date roleLastModifyTime) {
    this.roleLastModifyTime = roleLastModifyTime;
  }

  public Boolean getRoleValid() {
    return roleValid;
  }

  public void setRoleValid(Boolean roleValid) {
    this.roleValid = roleValid;
  }
}
