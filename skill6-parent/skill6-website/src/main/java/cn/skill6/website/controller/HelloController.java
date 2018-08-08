package cn.skill6.website.controller;

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
}
