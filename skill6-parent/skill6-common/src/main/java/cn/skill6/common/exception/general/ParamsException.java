package cn.skill6.common.exception.general;

import cn.skill6.common.exception.Skill6Exception;

/**
 * 参数异常
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年4月2日 上午10:51:22
 */
public class ParamsException extends Skill6Exception {
  private static final long serialVersionUID = 3117246804149890824L;

  public ParamsException() {
    super();
  }

  /**
   * @param errorCode
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public ParamsException(
      int errorCode,
      String message,
      Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace) {
    super(errorCode, message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param errorCode
   * @param message
   * @param cause
   */
  public ParamsException(int errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }

  /**
   * @param errorCode
   * @param message
   */
  public ParamsException(int errorCode, String message) {
    super(errorCode, message);
  }

  /**
   * @param errorCode
   * @param cause
   */
  public ParamsException(int errorCode, Throwable cause) {
    super(errorCode, cause);
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public ParamsException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message
   * @param cause
   */
  public ParamsException(String message, Throwable cause) {
    super(message, cause);
  }

  /** @param message */
  public ParamsException(String message) {
    super(message);
  }

  /** @param cause */
  public ParamsException(Throwable cause) {
    super(cause);
  }
}
