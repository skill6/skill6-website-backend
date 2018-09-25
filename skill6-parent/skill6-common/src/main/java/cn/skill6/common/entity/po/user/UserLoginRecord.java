package cn.skill6.common.entity.po.user;

import java.util.Date;

/**
 * 登录记录实体类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:35:52
 */
public class UserLoginRecord {
  private Long loginId;

  private String loginIp;

  private String loginType;

  private String loginEquipment;

  private Date loginTime;

  private String loginUserId;

  private Boolean loginSuccess;

  private String loginFailReason;

  @Override
  public String toString() {
    return "UserLoginRecord [loginId="
        + loginId
        + ", loginIp="
        + loginIp
        + ", loginType="
        + loginType
        + ", loginEquipment="
        + loginEquipment
        + ", loginTime="
        + loginTime
        + ", loginUserId="
        + loginUserId
        + ", loginSuccess="
        + loginSuccess
        + ", loginFailReason="
        + loginFailReason
        + "]";
  }

  public UserLoginRecord(
      Long loginId,
      String loginIp,
      String loginType,
      String loginEquipment,
      Date loginTime,
      String loginUserId,
      Boolean loginSuccess,
      String loginFailReason) {
    this.loginId = loginId;
    this.loginIp = loginIp;
    this.loginType = loginType;
    this.loginEquipment = loginEquipment;
    this.loginTime = loginTime;
    this.loginUserId = loginUserId;
    this.loginSuccess = loginSuccess;
    this.loginFailReason = loginFailReason;
  }

  public UserLoginRecord() {
    super();
  }

  public Long getLoginId() {
    return loginId;
  }

  public void setLoginId(Long loginId) {
    this.loginId = loginId;
  }

  public String getLoginIp() {
    return loginIp;
  }

  public void setLoginIp(String loginIp) {
    this.loginIp = loginIp == null ? null : loginIp.trim();
  }

  public String getLoginType() {
    return loginType;
  }

  public void setLoginType(String loginType) {
    this.loginType = loginType == null ? null : loginType.trim();
  }

  public String getLoginEquipment() {
    return loginEquipment;
  }

  public void setLoginEquipment(String loginEquipment) {
    this.loginEquipment = loginEquipment == null ? null : loginEquipment.trim();
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public String getLoginUserId() {
    return loginUserId;
  }

  public void setLoginUserId(String loginUserId) {
    this.loginUserId = loginUserId == null ? null : loginUserId.trim();
  }

  public Boolean getLoginSuccess() {
    return loginSuccess;
  }

  public void setLoginSuccess(Boolean loginSuccess) {
    this.loginSuccess = loginSuccess;
  }

  public String getLoginFailReason() {
    return loginFailReason;
  }

  public void setLoginFailReason(String loginFailReason) {
    this.loginFailReason = loginFailReason == null ? null : loginFailReason.trim();
  }
}
