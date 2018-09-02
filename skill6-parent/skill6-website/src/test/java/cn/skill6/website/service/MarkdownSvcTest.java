package cn.skill6.website.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.skill6.website.Skill6WebsiteApplicationTest;

@SpringBootTest
public class MarkdownSvcTest extends Skill6WebsiteApplicationTest {

  @Autowired MarkdownSvc markdownSvc;

  @Test
  public void toHtml() {
    Assert.assertEquals(
        "md转html失败",
        "<p>Hello world github / linguist＃1 <strong>cool</strong>，＃1！</p>\n",
        markdownSvc.toHtml("Hello world github / linguist＃1 **cool**，＃1！"));
  }
}
