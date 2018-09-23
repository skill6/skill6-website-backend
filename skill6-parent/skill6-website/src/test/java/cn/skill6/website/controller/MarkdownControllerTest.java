package cn.skill6.website.controller;

import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class MarkdownControllerTest extends Skill6WebsiteApplicationTest {

  @Test
  public void html() throws Exception {

    Map<String, String> map = new HashMap<>();
    map.put("text", "# abc");

    mockMvc
        .perform(
            post("/md")
                .content(JacksonUtil.toStr(map))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("<h1>abc</h1>\n"));
  }
}
