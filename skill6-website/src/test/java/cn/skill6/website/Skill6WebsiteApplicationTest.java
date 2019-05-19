package cn.skill6.website;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 测试基类
 *
 * @author 刘纪春
 * @version 1.0
 * @since 2018年9月15日 上午2:05:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Skill6WebsiteApplicationTest {

  @Autowired protected WebApplicationContext wac;

  @Autowired protected MockServletContext servletContext;

  @Autowired protected MockHttpSession session;

  @Autowired protected MockHttpServletRequest request;

  @Autowired protected MockHttpServletResponse response;

  @Autowired protected ServletWebRequest webRequest;

  protected static MockMvc mockMvc;

  @SuppressWarnings("static-access")
  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void loadContext() {}
}
