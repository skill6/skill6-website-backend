package cn.skill6.website.controller.article;

import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller测试类
 *
 * @author 何明胜
 * @version 1.3
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 指定测试方法按定义的顺序执行
public class ArticleInfoControllerTest extends Skill6WebsiteApplicationTest {

    private String articleId = SequenceManager.getNextIdStr();

    @Test
    public void test01AddArticle() throws Exception {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>(10);

        map.add("articleId", articleId);
        map.add("categoryId", "1");
        map.add("articleTitle", "Java入门");
        map.add("articleAuthor", "何明胜");
        map.add("articleSummary", "Jva入门基础知识");
        map.add("articleLabel", "Java,入门");
        map.add("articleHtmlContent", "Html内容");
        map.add("articleMdContent", "Markdown内容");

        mockMvc
                .perform(
                        post("/article")
                                .params(map)
                                .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void test02ModifyArticleById() throws Exception {
        mockMvc
                .perform(
                        put("/article")
                                .param("articleId", articleId)
                                .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void test03GetArticleById() throws Exception {
        mockMvc
                .perform(get("/article/" + articleId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void test04GetAllArticles() throws Exception {
        mockMvc
                .perform(get("/article/all").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.success").value(true))
                .andDo(print());
    }

    @Test
    public void test05DeleteArticleById() throws Exception {
        mockMvc
                .perform(delete("/article/" + articleId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.success").value(true));
    }
}
