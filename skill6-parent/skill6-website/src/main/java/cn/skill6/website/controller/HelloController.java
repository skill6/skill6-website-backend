package cn.skill6.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @ResponseBody
  @GetMapping("/helloskill6")
  public String helloSkill6() {
    return "hello skill6";
  }





  @GetMapping(
      value = {
        "/",
        "/topic",
        "/qa",
        "/code",
        "/project",
        "/source",
        "/talk",
        "/developing",
        "/topic/*",
        "/qa/*",
        "/code/*",
        "/project/*",
        "/source/*",
        "/talk/*",
        "/developing/*",
        "/topic/*/*",
      })
  public String index() {
    return "/index.html";
  }


}
