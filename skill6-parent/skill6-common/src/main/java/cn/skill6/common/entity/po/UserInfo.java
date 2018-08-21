package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 用户信息实体类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:36:56
 */
public class UserInfo {
  private Long userId;

  private String userNickName;

  private Date userRegisterTime;

  private String userHeadUrl;

  private Boolean userSex;

  private String userBirthday;

  private Boolean userBirthdayType;

  private String userDesc;

  private Date userLastLoginTime;

  public UserInfo(
      Long userId,
      String userNickName,
      Date userRegisterTime,
      String userHeadUrl,
      Boolean userSex,
      String userBirthday,
      Boolean userBirthdayType,
      String userDesc,
      Date userLastLoginTime) {
    this.userId = userId;
    this.userNickName = userNickName;
    this.userRegisterTime = userRegisterTime;
    this.userHeadUrl = userHeadUrl;
    this.userSex = userSex;
    this.userBirthday = userBirthday;
    this.userBirthdayType = userBirthdayType;
    this.userDesc = userDesc;
    this.userLastLoginTime = userLastLoginTime;
  }

  public UserInfo() {
    super();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserNickName() {
    return userNickName;
  }

  public void setUserNickName(String userNickName) {
    this.userNickName = userNickName == null ? null : userNickName.trim();
  }

  public Date getUserRegisterTime() {
    return userRegisterTime;
  }

  public void setUserRegisterTime(Date userRegisterTime) {
    this.userRegisterTime = userRegisterTime;
  }

  public String getUserHeadUrl() {
    return userHeadUrl;
  }

  public void setUserHeadUrl(String userHeadUrl) {
    this.userHeadUrl = userHeadUrl == null ? null : userHeadUrl.trim();
  }

  public Boolean getUserSex() {
    return userSex;
  }

  public void setUserSex(Boolean userSex) {
    this.userSex = userSex;
  }

  public String getUserBirthday() {
    return userBirthday;
  }

  public void setUserBirthday(String userBirthday) {
    this.userBirthday = userBirthday == null ? null : userBirthday.trim();
  }

  public Boolean getUserBirthdayType() {
    return userBirthdayType;
  }

  public void setUserBirthdayType(Boolean userBirthdayType) {
    this.userBirthdayType = userBirthdayType;
  }

  public String getUserDesc() {
    return userDesc;
  }

  public void setUserDesc(String userDesc) {
    this.userDesc = userDesc == null ? null : userDesc.trim();
  }

  public Date getUserLastLoginTime() {
    return userLastLoginTime;
  }

  public void setUserLastLoginTime(Date userLastLoginTime) {
    this.userLastLoginTime = userLastLoginTime;
  }
}
