package cn.skill6.dashboard.model.po;

import java.util.Date;

/**
 * 系统角色信息实体类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月27日 下午11:20:13
 */
public class SysRoleInfo {
  private Long roleId;

  private String roleName;

  private String roleCode;

  private String roleDesc;

  private Date roleCreateTime;

  private Date roleLastModifyTime;

  private Boolean roleValid;

  public SysRoleInfo(
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

  public SysRoleInfo() {
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
