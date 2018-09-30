package cn.skill6.website.config;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于配置SEO的拦截器，当请求用户为百度爬虫时启用Chrome Headless方式获取相应的结果并返回
 *
 * @author liujichun
 * @version 1.1
 */
@Configuration
public class SEOInterceptor implements HandlerInterceptor, WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new SEOInterceptor()).addPathPatterns("/**");
  }

  private String getSource(String uri) {
    WebDriver driver = null;
    try {
      driver = new ChromeDriver();
      driver.get(uri);
      return driver.getPageSource();
    } finally {
      if (driver != null) driver.quit();
    }
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws IOException {
    String agent = request.getHeader("User-Agent");
    if (StringUtils.isNotBlank(agent) && agent.toLowerCase().contains("baiduspider")) {
      response.setContentType(MediaType.TEXT_HTML_VALUE);
      response.setCharacterEncoding("utf-8");
      String source;
      try {
        source = getSource(request.getRequestURL().toString());
      } catch (Exception e) {
        return true;
      }
      response.getWriter().write(source);
      return false;
    }
    return true;
  }
}
