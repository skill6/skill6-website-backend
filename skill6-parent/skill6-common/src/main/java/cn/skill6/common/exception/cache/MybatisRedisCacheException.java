package cn.skill6.common.exception.cache;

import cn.skill6.common.exception.Skill6Exception;

/**
 * mybatis redis缓存异常
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年4月1日 下午11:22:50
 */
public class MybatisRedisCacheException extends Skill6Exception {

  private static final long serialVersionUID = 7613399559863282306L;

  public MybatisRedisCacheException() {
    super();
  }

  /**
   * @param errorCode
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public MybatisRedisCacheException(
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
  public MybatisRedisCacheException(int errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }

  /**
   * @param errorCode
   * @param message
   */
  public MybatisRedisCacheException(int errorCode, String message) {
    super(errorCode, message);
  }

  /**
   * @param errorCode
   * @param cause
   */
  public MybatisRedisCacheException(int errorCode, Throwable cause) {
    super(errorCode, cause);
  }

  /**
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public MybatisRedisCacheException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message
   * @param cause
   */
  public MybatisRedisCacheException(String message, Throwable cause) {
    super(message, cause);
  }

  /** @param message */
  public MybatisRedisCacheException(String message) {
    super(message);
  }

  /** @param cause */
  public MybatisRedisCacheException(Throwable cause) {
    super(cause);
  }
}
