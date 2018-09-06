package cn.skill6.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

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
