package cn.skill6.common.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import cn.skill6.common.constant.Encode;
import cn.skill6.common.exception.codec.CodecException;
import lombok.extern.slf4j.Slf4j;

/**
 * 类型转换
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年3月1日 下午1:01:47
 */
@Slf4j
public class ConvertType {

  /**
   * 字节数组转输入流
   *
   * @param byteArray
   */
  public static InputStream byteArray2InStream(byte[] byteArray) {
    return new ByteArrayInputStream(byteArray);
  }

  /**
   * 输入流转字节数组
   *
   * @param inStream
   * @throws IOException
   */
  public static byte[] inStream2ByteArray(InputStream inStream) throws IOException {
    byte[] buffer = new byte[256 * 1024];
    ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream();

    int length = 0;

    while ((length = inStream.read(buffer)) != -1) {
      log.trace(String.valueOf(length));
      bOutputStream.write(buffer, 0, length);
    }

    bOutputStream.close();

    return bOutputStream.toByteArray();
  }

  /**
   * 字符串转字节数组, 使用工程默认编码
   *
   * @param source
   * @throws CodecException
   */
  public static byte[] str2ByteArray(String source) throws CodecException {
    return str2ByteArray(source, Encode.DEFAULT_ENCODE);
  }

  /**
   * 字符串转字节数组
   *
   * @param source
   * @param encoding
   * @throws CodecException
   */
  public static byte[] str2ByteArray(String source, String encoding) throws CodecException {
    try {
      return source.getBytes(encoding);
    } catch (UnsupportedEncodingException e) {
      String msg =
          "Unable to convert source ["
              + source
              + "] to byte array using "
              + "encoding '"
              + encoding
              + "'";
      throw new CodecException(msg, e);
    }
  }

  /**
   * 字符串数组转String
   *
   * @param strArray
   */
  public static String strArray2String(String[] strArray) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < strArray.length; i++) {
      stringBuffer.append(strArray[i]);
    }

    return stringBuffer.toString();
  }

  /**
   * 字节数组转String
   *
   * @param byteArray
   * @throws UnsupportedEncodingException
   */
  public static String byteArray2String(byte[] byteArray) throws UnsupportedEncodingException {
    return new String(byteArray, Encode.DEFAULT_ENCODE);
  }
}
