package cn.skill6.common.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.DigestUtils;

/**
 * MD5加密工具, 支持加盐和定义加密次数
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年2月28日 下午12:09:52
 */
public class Md5Encrypt {
  /** 获取md5实例 */
  public static MessageDigest getMD5Instance() {
    MessageDigest messageDigest = null;

    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return messageDigest;
  }

  /**
   * MD5加密, 返回结果为小写字母+数字
   *
   * @param dataSource 待加密的数据
   * @return 加密后的字符串
   * @throws Exception
   */
  public static String getMD5Code(String dataSource) {
    return DigestUtils.md5DigestAsHex(dataSource.getBytes());
  }

  /**
   * MD5加密, 返回结果为大写字母+数字
   *
   * @param dataSource 待加密的数据
   * @return 加密后的字符串
   */
  public static String getMD5CodeUpperCase(String dataSource) {
    return getMD5Code(dataSource).toUpperCase();
  }

  /**
   * MD5加盐加密, 返回结果为小写字母+数字
   *
   * @param dataSource 待加密的数据
   * @param salt 盐
   * @return 加密后的字符串
   */
  public static String getMD5Code(String dataSource, String salt) {
    StringBuffer stingBuffer = new StringBuffer();
    MessageDigest digest = getMD5Instance();
    digest.update(salt.getBytes());
    byte[] byteArray = digest.digest(dataSource.getBytes());

    for (byte b : byteArray) {
      int i = b & 0xff;
      String hexString = Integer.toHexString(i);
      if (hexString.length() < 2) {
        hexString = "0" + hexString;
      }
      stingBuffer.append(hexString);
    }

    return stingBuffer.toString();
  }

  /**
   * MD5加盐多次加密, 返回结果为小写字母+数字
   *
   * @param dataSource 待加密的数据
   * @param salt 盐
   * @param iterations 加密次数
   * @return 加密后的字符串
   */
  public static String getMD5Code(String dataSource, String salt, int iterations) {
    MessageDigest digest = getMD5Instance();

    if (salt != null) {
      digest.reset();
      digest.update(salt.getBytes());
    }

    byte[] byteArray = digest.digest(dataSource.getBytes());

    for (int i = 0; i < iterations - 1; i++) {
      digest.reset();
      byteArray = digest.digest(byteArray);
    }

    return new BigInteger(1, byteArray).toString(16);
  }
}
