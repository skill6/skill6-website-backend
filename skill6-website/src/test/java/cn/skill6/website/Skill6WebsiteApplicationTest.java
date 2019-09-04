package cn.skill6.website;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 测试基类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-18 19:37
 */
@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class Skill6WebsiteApplicationTest {

    @Autowired
    protected WebApplicationContext wac;

    protected static MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void initContext() {
    }
}
