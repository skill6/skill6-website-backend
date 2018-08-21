package cn.skill6.common.entity.po;

/**
 * 用户隐私信息实体类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:37:40
 */
public class UserPrivacyInfo {
  private Long userId;

  private String userName;

  private String userEmail;

  private String userPhone;

  private String userLoginFrom;

  private String userPassword;

  private String userPwdSalt;

  private String userType;

  private String userState;

  public UserPrivacyInfo(
      Long userId,
      String userName,
      String userEmail,
      String userPhone,
      String userLoginFrom,
      String userPassword,
      String userPwdSalt,
      String userType,
      String userState) {
    this.userId = userId;
    this.userName = userName;
    this.userEmail = userEmail;
    this.userPhone = userPhone;
    this.userLoginFrom = userLoginFrom;
    this.userPassword = userPassword;
    this.userPwdSalt = userPwdSalt;
    this.userType = userType;
    this.userState = userState;
  }

  public UserPrivacyInfo() {
    super();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail == null ? null : userEmail.trim();
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone == null ? null : userPhone.trim();
  }

  public String getUserLoginFrom() {
    return userLoginFrom;
  }

  public void setUserLoginFrom(String userLoginFrom) {
    this.userLoginFrom = userLoginFrom == null ? null : userLoginFrom.trim();
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword == null ? null : userPassword.trim();
  }

  public String getUserPwdSalt() {
    return userPwdSalt;
  }

  public void setUserPwdSalt(String userPwdSalt) {
    this.userPwdSalt = userPwdSalt == null ? null : userPwdSalt.trim();
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType == null ? null : userType.trim();
  }

  public String getUserState() {
    return userState;
  }

  public void setUserState(String userState) {
    this.userState = userState == null ? null : userState.trim();
  }
}
