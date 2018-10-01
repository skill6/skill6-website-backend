package cn.skill6.common.exception.tools;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 返回程序调用的堆栈轨迹
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年2月3日 下午4:59:14
 */
public class StackTrace2Str {
  /** @return e.printStackTrace()的内容 */
  public static String exceptionStackTrace2Str(Exception e) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    // 将出错的栈信息输出到printWriter中
    e.printStackTrace(pw);
    pw.flush();
    sw.flush();

    return sw.toString();
  }

  /**
   * 返回 自定义错误信息 + e.printStackTrace()的内容
   *
   * @param errorMsg
   * @param e
   */
  public static String exceptionStackTrace2Str(String errorMsg, Exception e) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    // 将出错的栈信息输出到printWriter中
    e.printStackTrace(pw);
    pw.flush();
    sw.flush();

    return errorMsg + "\n" + sw.toString();
  }
}
