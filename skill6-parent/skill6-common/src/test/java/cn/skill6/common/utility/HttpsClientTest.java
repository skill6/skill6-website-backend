package cn.skill6.common.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import cn.skill6.common.transform.JacksonUtil;

/**
 * http请求测试
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 上午12:30:41
 */
public class HttpsClientTest {
  @Test
  public void testDoGet() throws IOException {
    String url = "https://api.github.com/user";
    Map<String, String> params = new HashMap<>(1);
    params.put("access_token", "a313187e194b010cf45c3e0353417fef548ff0d3");

    String response = HttpsClient.doGet(url, params);

    if (StringUtils.isNotEmpty(response)) {
      Map<String, Object> map = JacksonUtil.str2Map(response);

      for (Map.Entry<String, Object> entry : map.entrySet()) {
        System.out.println(StringUtils.join(entry.getKey(), ": ", entry.getValue()));
      }
    }
  }

  @Test
  public void testDoPost() throws IOException {
    String url = "https://github.com/login/oauth/access_token";
    Map<String, String> params = new HashMap<>(3);
    params.put("client_id", "269af35a7565687859d4");
    params.put("client_secret", "171af15beb8136ff9912643d27f85b1b4bd38a8c");
    params.put("code", "48fad354dc27dc45ea2c");

    String response = HttpsClient.doPost(url, params);

    System.out.println(response);
  }
}
