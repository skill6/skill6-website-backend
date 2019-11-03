package cn.skill6.website.controller.store;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 文件下载测试类
 *
 * @author 何明胜
 * @since 2018年9月19日 下午6:51:45
 */
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreFileControllerTest extends Skill6WebsiteApplicationTest {

    private static String urlDownload = null;

    @Test
    public void test01UploadFile() throws Exception {
        fileUploadMock("/file/share");
    }

    @Test
    public void test02UploadAttachment() throws Exception {
        fileUploadMock("/file/attach");
    }

    /**
     * 文件上传公共函数
     */
    public void fileUploadMock(String uploadUrl) throws Exception {
        MockMultipartFile firstFile = new MockMultipartFile(
            "text_file_upload.txt",
            "text_file_upload.txt",
            MediaType.TEXT_PLAIN_VALUE,
            "模拟文件".getBytes());

        MvcResult mvcResult = mockMvc
            .perform(multipart(uploadUrl).file(firstFile).param("some-random", "4"))
            .andExpect(status().isOk())
            .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        Object message = JacksonUtil.toObj(response, ResponseJson.class).getMessage();

        Map<String, String> obj2Map = JacksonUtil.obj2Map(message);
        urlDownload = obj2Map.get("file_url");
    }

    @Test
    public void test03DownloadFileById() throws Exception {
        mockMvc.perform(get(urlDownload).
            accept(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE))).
            andExpect(status().isOk());
    }
}
