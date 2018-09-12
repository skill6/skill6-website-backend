package cn.skill6.common.utility;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求解析器，解析请求中的域名、端口等
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月12日 下午6:59:17
 */
public class RequestParser {

  public static StringBuffer parseContextIndex(HttpServletRequest request) {
    StringBuffer url = request.getRequestURL();
    String uri = request.getRequestURI();

    StringBuffer contextUrl = url.delete(url.length() - uri.length(), url.length());

    return contextUrl;
  }
}
