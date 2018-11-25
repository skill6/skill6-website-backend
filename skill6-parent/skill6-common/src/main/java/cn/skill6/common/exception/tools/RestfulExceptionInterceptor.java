package cn.skill6.common.exception.tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.skill6.common.constant.Encode;
import cn.skill6.common.constant.HttpStatusCode;
import cn.skill6.common.entity.vo.ResponseJson;
import lombok.extern.slf4j.Slf4j;

/**
 * restful请求异常拦截器
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年5月19日 上午1:13:11
 */
@Slf4j
public class RestfulExceptionInterceptor implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      Exception exception) {
    // 未登录异常
    if (exception instanceof UnauthenticatedException) {
      response.setStatus(HttpStatusCode.UNAUTHORIZED);

      log.error(StackTrace2Str.exceptionStackTrace2Str("捕获未登录异常", exception));
      handleUnauthenticatedException(response);

      return null;
    }
    // 无权限异常
    if (exception instanceof UnauthorizedException || exception instanceof AuthorizationException) {
      response.setStatus(HttpStatusCode.UNAUTHORIZED);

      log.error(StackTrace2Str.exceptionStackTrace2Str("捕获无权限异常", exception));
      handleUnauthorizedException(response);

      return null;
    }

    return null;
  }

  /**
   * 处理未登录异常
   *
   * @param response
   */
  private void handleUnauthenticatedException(HttpServletResponse response) {
    try {
      response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
      response.setCharacterEncoding(Encode.DEFAULT_ENCODE);
      PrintWriter writer = response.getWriter();

      ResponseJson responseJson = new ResponseJson(false, "您尚未登录, 请先登录!");
      writer.write(new ObjectMapper().writeValueAsString(responseJson));

      writer.flush();
      writer.close();
    } catch (IOException e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("异常系统捕获处理时再次异常", e));
    }
  }

  /**
   * 处理无权限异常
   *
   * @param response
   */
  private void handleUnauthorizedException(HttpServletResponse response) {
    try {
      response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
      response.setCharacterEncoding(Encode.DEFAULT_ENCODE);
      PrintWriter writer = response.getWriter();

      ResponseJson responseJson = new ResponseJson(false, "您没有相应的操作权限!");
      writer.write(new ObjectMapper().writeValueAsString(responseJson));

      writer.flush();
      writer.close();
    } catch (IOException e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("异常系统捕获处理时再次异常", e));
    }
  }
}
