package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 用户信息修改记录实体类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:37:07
 */
public class UserModifyRecord {
  private String userId;

  private String userModifyType;

  private Date userModifyDate;

  private String userModifyBefore;

  private String userModifyAfter;

  private Boolean userModufySuccess;

  public UserModifyRecord(
      String userId,
      String userModifyType,
      Date userModifyDate,
      String userModifyBefore,
      String userModifyAfter,
      Boolean userModufySuccess) {
    this.userId = userId;
    this.userModifyType = userModifyType;
    this.userModifyDate = userModifyDate;
    this.userModifyBefore = userModifyBefore;
    this.userModifyAfter = userModifyAfter;
    this.userModufySuccess = userModufySuccess;
  }

  public UserModifyRecord() {
    super();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId.trim();
  }

  public String getUserModifyType() {
    return userModifyType;
  }

  public void setUserModifyType(String userModifyType) {
    this.userModifyType = userModifyType == null ? null : userModifyType.trim();
  }

  public Date getUserModifyDate() {
    return userModifyDate;
  }

  public void setUserModifyDate(Date userModifyDate) {
    this.userModifyDate = userModifyDate;
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
