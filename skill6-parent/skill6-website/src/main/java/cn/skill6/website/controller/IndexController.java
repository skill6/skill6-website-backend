package cn.skill6.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

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
        "/blog/editor",
        "/login"
      })
  public String index() {
    return "/index.html";
  }
}
