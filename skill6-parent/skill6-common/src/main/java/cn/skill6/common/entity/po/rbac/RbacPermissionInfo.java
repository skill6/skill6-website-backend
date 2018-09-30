package cn.skill6.common.entity.po.rbac;

import java.util.Date;

/**
 * RBAC权限信息
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月23日 下午5:52:40
 */
public class RbacPermissionInfo {
  private Long permissionId;

  private String permissionName;

  private String permissionCode;

  private String permissionDesc;

  private Boolean permissionNavi;

  private String permissionUrl;

  private Date permissionCreateTime;

  private Date permissionLastModifyTime;

  private Boolean permissionValid;

  @Override
  public String toString() {
    return "RbacPermissionInfo [permissionId="
        + permissionId
        + ", permissionName="
        + permissionName
        + ", permissionCode="
        + permissionCode
        + ", permissionDesc="
        + permissionDesc
        + ", permissionNavi="
        + permissionNavi
        + ", permissionUrl="
        + permissionUrl
        + ", permissionCreateTime="
        + permissionCreateTime
        + ", permissionLastModifyTime="
        + permissionLastModifyTime
        + ", permissionValid="
        + permissionValid
        + "]";
  }

  public RbacPermissionInfo(
      Long permissionId,
      String permissionName,
      String permissionCode,
      String permissionDesc,
      Boolean permissionNavi,
      String permissionUrl,
      Date permissionCreateTime,
      Date permissionLastModifyTime,
      Boolean permissionValid) {
    this.permissionId = permissionId;
    this.permissionName = permissionName;
    this.permissionCode = permissionCode;
    this.permissionDesc = permissionDesc;
    this.permissionNavi = permissionNavi;
    this.permissionUrl = permissionUrl;
    this.permissionCreateTime = permissionCreateTime;
    this.permissionLastModifyTime = permissionLastModifyTime;
    this.permissionValid = permissionValid;
  }

  public RbacPermissionInfo() {
    super();
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName == null ? null : permissionName.trim();
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public void setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode == null ? null : permissionCode.trim();
  }

  public String getPermissionDesc() {
    return permissionDesc;
  }

  public void setPermissionDesc(String permissionDesc) {
    this.permissionDesc = permissionDesc == null ? null : permissionDesc.trim();
  }

  public Boolean getPermissionNavi() {
    return permissionNavi;
  }

  public void setPermissionNavi(Boolean permissionNavi) {
    this.permissionNavi = permissionNavi;
  }

  public String getPermissionUrl() {
    return permissionUrl;
  }

  public void setPermissionUrl(String permissionUrl) {
    this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
  }

  public Date getPermissionCreateTime() {
    return permissionCreateTime;
  }

  public void setPermissionCreateTime(Date permissionCreateTime) {
    this.permissionCreateTime = permissionCreateTime;
  }

  public Date getPermissionLastModifyTime() {
    return permissionLastModifyTime;
  }

  public void setPermissionLastModifyTime(Date permissionLastModifyTime) {
    this.permissionLastModifyTime = permissionLastModifyTime;
  }

  public Boolean getPermissionValid() {
    return permissionValid;
  }

  public void setPermissionValid(Boolean permissionValid) {
    this.permissionValid = permissionValid;
  }
}
