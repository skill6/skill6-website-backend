package cn.skill6.website.controller.complex;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.skill6.service.complex.MarkdownSvc;

@Controller
@RequestMapping(value = "md")
public class MarkdownController {

  @Autowired MarkdownSvc markdownSvc;

  @PostMapping
  @ResponseBody
  public String html(@RequestBody Req req, HttpServletResponse response) {
    response.setCharacterEncoding("UTF-8");
    response.setContentType(MediaType.TEXT_HTML_VALUE);
    return markdownSvc.toHtml(req.getText());
  }

  private static class Req {
    private String text;

    public String getText() {
      return text;
    }

    @SuppressWarnings("unused")
    public void setText(String text) {
      this.text = text;
    }
  }
}
