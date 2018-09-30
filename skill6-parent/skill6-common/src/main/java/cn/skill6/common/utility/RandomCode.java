package cn.skill6.common.utility;

/**
 * 获取指定长度的验证码
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年2月28日 下午12:11:20
 */
public class RandomCode {
  /**
   * @param length
   * @return int类型的验证码
   */
  public static int producedRandomCode(double length) {
    int randomCode = (int) (Math.random() * Math.pow(10, length));
    // 进制系统,这里是10进制
    int decimalSystem = 10;

    while (randomCode < Math.pow(decimalSystem, length - 1)
        || randomCode >= Math.pow(decimalSystem, length)) {
      randomCode = (int) (Math.random() * Math.pow(10, length));
    }

    return randomCode;
  }

  /**
   * @param length
   * @return String类型的验证码
   */
  public static String producedRandomCodeStr(double length) {
    return String.valueOf(producedRandomCode(length));
  }

  /** @return 长度为6的字符串验证码 */
  public static String producedRandomCodeStr6() {
    return String.valueOf(producedRandomCode(6));
  }
}
