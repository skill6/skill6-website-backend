package cn.skill6.common.exception.general;

import cn.skill6.common.exception.Skill6Exception;

/**
 * 格式异常，如目录含有非法字符
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月4日 上午1:43:09
 */
public class FormatException extends Skill6Exception {

  private static final long serialVersionUID = 8193274044249365942L;

  public FormatException() {
    super();
  }

  /**
   * @param errorCode
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public FormatException(
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
  public FormatException(int errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }

  /**
   * @param errorCode
   * @param message
   */
  public FormatException(int errorCode, String message) {
    super(errorCode, message);
  }

  /**
   * @param errorCode
   * @param cause
   */
  public FormatException(int errorCode, Throwable cause) {
    super(errorCode, cause);
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public FormatException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message
   * @param cause
   */
  public FormatException(String message, Throwable cause) {
    super(message, cause);
  }

  /** @param message */
  public FormatException(String message) {
    super(message);
  }

  /** @param cause */
  public FormatException(Throwable cause) {
    super(cause);
  }
}
