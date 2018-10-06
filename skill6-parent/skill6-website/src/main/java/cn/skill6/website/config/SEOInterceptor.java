package cn.skill6.website.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于配置SEO的拦截器，当请求用户为百度爬虫时启用Chrome Headless方式获取相应的结果并返回
 *
 * @author liujichun
 * @version 1.2
 */
@Slf4j
@Configuration
public class SEOInterceptor implements HandlerInterceptor, WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new SEOInterceptor()).addPathPatterns("/**");
  }

  @Bean
  public WebDriver webDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments(
        "--headless", "--no-sandbox", "--disable-gpu", "--disable-dev-shm-usage");
    return new ChromeDriver(chromeOptions);
  }

  @PreDestroy
  public void destory() {
    WebDriver webDriver = webDriver();
    if (webDriver != null) webDriver.quit();
  }

  private String getSource(String uri) {
    WebDriver webDriver = webDriver();
    webDriver.get(uri);
    return webDriver.getPageSource();
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
        log.debug("chromedriver get {} -> {}", request.getRequestURL().toString(), source);
      } catch (Exception e) {
        e.printStackTrace();
        return true;
      }
      response.getWriter().write(source);
      return false;
    }
    return true;
  }
}
