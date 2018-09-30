package cn.skill6.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * spring mvc 控制器基类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年3月5日 下午3:42:44
 */
public class BaseController {
  protected HttpServletRequest request;
  protected HttpServletResponse response;
  protected HttpSession session;

  /**
   * ModelAttribute注解 表示先执行
   *
   * @param request
   * @param response
   */
  @ModelAttribute
  public void setHttpAttribute(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.session = request.getSession();
  }
}
