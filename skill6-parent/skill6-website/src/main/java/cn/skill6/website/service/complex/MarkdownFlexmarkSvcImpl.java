package cn.skill6.website.service.complex;

import java.util.Arrays;

import cn.skill6.service.complex.MarkdownSvc;
import org.springframework.stereotype.Service;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.MutableDataSet;

/**
 * 使用Flexmark方式对Md文本进行处理
 *
 * @author liujichun
 */
@Service
public class MarkdownFlexmarkSvcImpl implements MarkdownSvc {

  /** 将md转化为对应的html */
  @Override
  public String toHtml(String md) {
    return parse(md);
  }

  private static String parse(String content) {
    MutableDataSet options = new MutableDataSet();
    options.setFrom(ParserEmulationProfile.MARKDOWN);
    options.set(
        Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), EmojiExtension.create()));
    Parser parser = Parser.builder(options).build();
    HtmlRenderer renderer = HtmlRenderer.builder(options).build();
    Node document = parser.parse(content);
    return renderer.render(document);
  }

}
