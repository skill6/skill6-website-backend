package cn.skill6.website.controller.sign;

import cn.skill6.website.Skill6WebsiteApplicationTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 注册测试
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-27 00:49
 */
public class SignUpControllerTest extends Skill6WebsiteApplicationTest {

    @Test
    public void test01CreateUser() throws Exception {
        LinkedMultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>(2);

        paramMap.add("userName", "husen_test");
        paramMap.add("password", "123456");

        mockMvc
                .perform(
                        post("/register")
                                .params(paramMap)
                                .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
