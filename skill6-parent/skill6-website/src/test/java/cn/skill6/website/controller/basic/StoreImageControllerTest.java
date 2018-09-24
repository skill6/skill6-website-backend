package cn.skill6.website.controller.basic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.Skill6WebsiteApplicationTest;

/**
 * 图片上传测试类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月21日 上午12:19:12
 */
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreImageControllerTest extends Skill6WebsiteApplicationTest {

  private static String urlDownload = null;

  @SuppressWarnings("unchecked")
  @Test
  public void test01UploadImage() throws Exception {
    MockMultipartFile firstFile =
        new MockMultipartFile(
            "text_file_upoad.txt",
            "text_file_upoad.txt",
            MediaType.TEXT_PLAIN_VALUE,
            "模拟图片".getBytes());

    MvcResult mvcResult =
        mockMvc
            .perform(multipart("/image").file(firstFile).param("key", "value"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andReturn();

    String response = mvcResult.getResponse().getContentAsString();
    Object message = JacksonUtil.jsonStr2Entity(response, ResponseJson.class).getMessage();
    urlDownload = ((Map<String, String>) message).get("image_url");
  }

  @Test
  public void test02DownloadImageById() throws Exception {
    mockMvc
        .perform(
            get(urlDownload)
                .accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE)))
        .andExpect(status().isOk());
  }
}
