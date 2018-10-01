package cn.skill6.common.utility;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求解析器，解析请求中的域名、端口等
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月12日 下午6:59:17
 */
public class RequestParser {

  /**
   * 根据请求得到请求index，如：http://127.0.0.1:8080
   *
   * @param request
   */
  public static StringBuffer parseContextIndex(HttpServletRequest request) {
    StringBuffer url = request.getRequestURL();
    String uri = request.getRequestURI();

    StringBuffer contextUrl = url.delete(url.length() - uri.length(), url.length());

    return contextUrl;
  }
}
