package cn.skill6.website.service;

import static cn.skill6.website.consts.Consts.GITHUB_MARKDOWN_RENDER_V3_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Markdown相关服务，支持多种解析方式
 */
@Service
public class MarkdownSvc {

  private static final Logger LOGGER = LoggerFactory.getLogger(MarkdownSvc.class);

  @Autowired private RestTemplate restTemplate;

  public String toHtml(String md) {
    GithubMarkdownReq req = new GithubMarkdownReq(md);
    LOGGER.debug("==> Github Markdown to html rep:{}", req);
    String html = restTemplate.postForObject(GITHUB_MARKDOWN_RENDER_V3_URL, req, String.class);
    LOGGER.debug("<== Github markdown to html resp:{}", html);
    return html;
  }

  private static class GithubMarkdownReq {
    private String text;
    private String mode = "markdown";

    public GithubMarkdownReq() {}

    public GithubMarkdownReq(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getMode() {
      return mode;
    }

    public void setMode(String mode) {
      this.mode = mode;
    }
  }
}
