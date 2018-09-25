package cn.skill6.common.entity.po.user;

import java.util.Date;

/**
 * 用户信息修改记录实体类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:37:07
 */
public class UserModifyRecord {
  private Long userId;

  private String userModifyType;

  private Date userModifyTime;

  private String userModifyBefore;

  private String userModifyAfter;

  private Boolean userModufySuccess;

  @Override
  public String toString() {
    return "UserModifyRecord [userId="
        + userId
        + ", userModifyType="
        + userModifyType
        + ", userModifyTime="
        + userModifyTime
        + ", userModifyBefore="
        + userModifyBefore
        + ", userModifyAfter="
        + userModifyAfter
        + ", userModufySuccess="
        + userModufySuccess
        + "]";
  }

  public UserModifyRecord(
      Long userId,
      String userModifyType,
      Date userModifyTime,
      String userModifyBefore,
      String userModifyAfter,
      Boolean userModufySuccess) {
    this.userId = userId;
    this.userModifyType = userModifyType;
    this.userModifyTime = userModifyTime;
    this.userModifyBefore = userModifyBefore;
    this.userModifyAfter = userModifyAfter;
    this.userModufySuccess = userModufySuccess;
  }

  public UserModifyRecord() {
    super();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserModifyType() {
    return userModifyType;
  }

  public void setUserModifyType(String userModifyType) {
    this.userModifyType = userModifyType == null ? null : userModifyType.trim();
  }

  public Date getUserModifyTime() {
    return userModifyTime;
  }

  public void setUserModifyTime(Date userModifyTime) {
    this.userModifyTime = userModifyTime;
  }

  public String getUserModifyBefore() {
    return userModifyBefore;
  }

  public void setUserModifyBefore(String userModifyBefore) {
    this.userModifyBefore = userModifyBefore == null ? null : userModifyBefore.trim();
  }

  public String getUserModifyAfter() {
    return userModifyAfter;
  }

  public void setUserModifyAfter(String userModifyAfter) {
    this.userModifyAfter = userModifyAfter == null ? null : userModifyAfter.trim();
  }

  public Boolean getUserModufySuccess() {
    return userModufySuccess;
  }

  public void setUserModufySuccess(Boolean userModufySuccess) {
    this.userModufySuccess = userModufySuccess;
  }
}
