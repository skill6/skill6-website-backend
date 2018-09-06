package cn.skill6.website.service;

import org.junit.Assert;
import org.junit.Test;

public class MarkdownFlexmarkSvcTest {

  @Test
  public void toHtml() {
    Assert.assertEquals(
        "Markdown转换失败",
        "<p>Hello world github / linguist＃1 <strong>cool</strong>，＃1！</p>\n",
        new MarkdownFlexmarkSvc().toHtml("Hello world github / linguist＃1 **cool**，＃1！"));
  }
}
