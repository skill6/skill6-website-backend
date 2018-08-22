package cn.skill6.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeoController {

  @Value("${server.port}")
  private int port;

  @GetMapping(
      value = "/**",
      headers = {"User-Agent=*Baiduspider*"})
  @ResponseBody
  public String Baiduspider(HttpServletRequest request) {
    return getSource(request.getRequestURI());
  }

  public String getSource(String uri) {
    WebDriver driver = null;
    try {
      driver = new ChromeDriver();
      driver.get("http://localhost:" + port + "uri");
      return driver.getPageSource();
    } finally {
      if (driver != null) driver.quit();
    }
  }
}
