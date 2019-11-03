package cn.skill6.website.controller.sign;

import cn.skill6.website.Skill6WebsiteApplicationTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 登录测试
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-27 00:50
 */
public class SignInControllerTest extends Skill6WebsiteApplicationTest {

    @Test
    public void test01LoginIn() throws Exception {
        LinkedMultiValueMap<String, String> paramMap = new LinkedMultiValueMap<String, String>(2);

        paramMap.add("username", "husen");
        paramMap.add("password", "123456");

        mockMvc.perform(
                post("/login/username")
                        .params(paramMap))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test02QueryLoginState() throws Exception {
        mockMvc.perform(
                get("/auth/authenticated")
                        .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

}
