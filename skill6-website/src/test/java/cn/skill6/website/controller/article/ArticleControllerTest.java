package cn.skill6.website.controller.article;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller测试类
 *
 * @author 何明胜
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 指定测试方法按定义的顺序执行
public class ArticleControllerTest extends Skill6WebsiteApplicationTest {

    private String articleId = SequenceManager.getNextIdStr();

    @Test
    public void test01AddArticle() throws Exception {
        ArticleInfo articleInfo = ArticleInfo.builder().articleId(Long.parseLong(articleId))
            .categoryId(12412L)
            .articleTitle("Java入门")
            .articleAuthor("何明胜")
            .articleSummary("Jva入门基础知识")
            .articleLabel("Java,入门")
            .articleHtmlContent("Html内容")
            .articleMdContent("Markdown内容")
            .build();

        mockMvc
            .perform(
                post("/api/article")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JacksonUtil.toStr(articleInfo))
                    .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void test02ModifyArticleById() throws Exception {
        ArticleInfo articleInfo = ArticleInfo.builder().articleId(Long.parseLong(articleId))
            .build();

        mockMvc
            .perform(
                put("/api/article")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JacksonUtil.toStr(articleInfo))
                    .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void test03GetArticleById() throws Exception {
        mockMvc
            .perform(get("/api/article/" + articleId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk());
    }

    @Test
    public void test04GetArticlesByPage() throws Exception {
        mockMvc
            .perform(get("/api/article")
                .param("pageSize", "10")
                .param("pageNum", "1").
                    accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void test05DeleteArticleById() throws Exception {
        mockMvc
            .perform(
                delete("/api/article/" + articleId)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
