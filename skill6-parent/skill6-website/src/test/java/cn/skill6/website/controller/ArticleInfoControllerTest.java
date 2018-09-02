package cn.skill6.website.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.website.Skill6WebsiteApplicationTest;

/**
 * Controller测试类
 *
 * @author liujichun
 * @version 1.0.0
 */
@SpringBootTest
public class ArticleInfoControllerTest extends Skill6WebsiteApplicationTest {

  @SuppressWarnings("static-access")
  @Test
  public void addArticle() throws Exception {
    this.mockMvc
        .perform(
            post("/article", new ArticleInfo())
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.success").value(false));
  }

  @SuppressWarnings("static-access")
  @Test
  public void deleteArticleById() throws Exception {
    this.mockMvc
        .perform(delete("/article/001").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.success").value(true));
  }

  @Test
  public void modifyArticleById() {}

  @Test
  public void getArticleById() {}

  @Test
  public void getAllArticles() {}
}
