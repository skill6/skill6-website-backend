package cn.skill6.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

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
        "/blog/editor"
      })
  public String index() {
    return "/index.html";
  }
}
