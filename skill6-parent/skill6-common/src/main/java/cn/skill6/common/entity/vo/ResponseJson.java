package cn.skill6.common.entity.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * RESTful 返回json
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年3月21日 下午3:52:46
 */
@JsonInclude(Include.NON_NULL)
public class ResponseJson implements Serializable {
  private static final long serialVersionUID = 1L;

  /** 不使用封装,默认为false */
  private Boolean success;

  private Object message;

  @Override
  public String toString() {
    return "SimpleJson [success=" + success + ", message=" + message + "]";
  }

  public ResponseJson() {
    super();
  }

  /**
   * 只有结果
   *
   * @param success
   */
  public ResponseJson(Boolean success) {
    super();
    this.success = success;
  }

  /**
   * 结果带说明信息
   *
   * @param success
   * @param message
   */
  public ResponseJson(Boolean success, Object message) {
    super();
    this.success = success;
    this.message = message;
  }

  /** @return the success */
  public Boolean getSuccess() {
    return success;
  }

  /** @param success the success to set */
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /** @return the message */
  public Object getMessage() {
    return message;
  }

  /** @param message the message to set */
  public void setMessage(Object message) {
    this.message = message;
  }
}
