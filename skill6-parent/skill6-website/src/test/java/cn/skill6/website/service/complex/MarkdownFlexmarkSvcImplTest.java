package cn.skill6.website.service.complex;

import org.junit.Assert;
import org.junit.Test;

import cn.skill6.website.service.complex.MarkdownFlexmarkSvcImpl;

public class MarkdownFlexmarkSvcImplTest {

  @Test
  public void toHtml() {
    Assert.assertEquals(
        "Markdown转换失败",
        "<p>Hello world github / linguist＃1 <strong>cool</strong>，＃1！</p>\n",
        new MarkdownFlexmarkSvcImpl().toHtml("Hello world github / linguist＃1 **cool**，＃1！"));
  }
}
