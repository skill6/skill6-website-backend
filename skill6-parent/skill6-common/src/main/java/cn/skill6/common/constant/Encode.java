package cn.skill6.common.constant;

import java.io.UnsupportedEncodingException;

/**
 * 工程编码管理
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年2月5日 上午11:58:38
 */
public class Encode {
  /** 常用编码名称 */
  public static final String ENCODE_UTF8 = "UTF-8";

  public static final String ENCODE_GBK = "GBK";
  public static final String ENCODE_ISO8859 = "ISO-8859-1";

  /** 工程默认编码 UTF-8 */
  public static final String DEFAULT_ENCODE = ENCODE_UTF8;

  /**
   * ISO-8859-1 转 GBK
   *
   * @param originStr
   * @throws UnsupportedEncodingException
   */
  public static String iso2GBK(String originStr) throws UnsupportedEncodingException {
    return new String(originStr.getBytes(ENCODE_ISO8859), ENCODE_GBK);
  }

  /**
   * ISO-8859-1 转 UTF-8
   *
   * @param originStr
   * @throws UnsupportedEncodingException
   */
  public static String iso2UTF8(String originStr) throws UnsupportedEncodingException {
    return new String(originStr.getBytes(ENCODE_ISO8859), DEFAULT_ENCODE);
  }
}
