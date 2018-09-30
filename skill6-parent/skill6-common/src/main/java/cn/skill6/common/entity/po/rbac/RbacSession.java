package cn.skill6.common.entity.po.rbac;

import java.util.Date;

/**
 * RBAC会话存储
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月24日 上午2:44:03
 */
public class RbacSession {
  private Long sessionId;

  private Date sessionCreateTime;

  private Date sessionLastModifyTime;

  private Boolean sessionValid;

  private String sessionContent;

  @Override
  public String toString() {
    return "RbacSession [sessionId="
        + sessionId
        + ", sessionCreateTime="
        + sessionCreateTime
        + ", sessionLastModifyTime="
        + sessionLastModifyTime
        + ", sessionValid="
        + sessionValid
        + ", sessionContent="
        + sessionContent
        + "]";
  }

  public RbacSession(
      Long sessionId,
      Date sessionCreateTime,
      Date sessionLastModifyTime,
      Boolean sessionValid,
      String sessionContent) {
    this.sessionId = sessionId;
    this.sessionCreateTime = sessionCreateTime;
    this.sessionLastModifyTime = sessionLastModifyTime;
    this.sessionValid = sessionValid;
    this.sessionContent = sessionContent;
  }

  public RbacSession() {
    super();
  }

  public Long getSessionId() {
    return sessionId;
  }

  public void setSessionId(Long sessionId) {
    this.sessionId = sessionId;
  }

  public Date getSessionCreateTime() {
    return sessionCreateTime;
  }

  public void setSessionCreateTime(Date sessionCreateTime) {
    this.sessionCreateTime = sessionCreateTime;
  }

  public Date getSessionLastModifyTime() {
    return sessionLastModifyTime;
  }

  public void setSessionLastModifyTime(Date sessionLastModifyTime) {
    this.sessionLastModifyTime = sessionLastModifyTime;
  }

  public Boolean getSessionValid() {
    return sessionValid;
  }

  public void setSessionValid(Boolean sessionValid) {
    this.sessionValid = sessionValid;
  }

  public String getSessionContent() {
    return sessionContent;
  }

  public void setSessionContent(String sessionContent) {
    this.sessionContent = sessionContent == null ? null : sessionContent.trim();
  }
}
