package cn.skill6.website.config;

import cn.skill6.website.Skill6WebsiteApplicationTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SEOInterceptorTest extends Skill6WebsiteApplicationTest {

    @Test
    public void preHandle() throws Exception {
        mockMvc
                .perform(
                        get("/")
                                .header(
                                        "User-Agent",
                                        "Mozilla/5.0 (compatible; Baiduspider-render/2.0; +http://www.baidu.com/search/spider.html)"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
