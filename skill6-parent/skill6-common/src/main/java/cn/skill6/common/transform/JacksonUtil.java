package cn.skill6.common.transform;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;

/**
 * 封装jackson转换为全局方法
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月26日 下午11:36:57
 */
public class JacksonUtil {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static <T> T map2Entity(Map<String, String> map, Class<T> clazz) throws IOException {
    String jsonStr = objectMapper.writeValueAsString(map);

    //驼峰和下划线格式自动转换
    objectMapper.setPropertyNamingStrategy(SnakeCaseStrategy.SNAKE_CASE);

    return (T) objectMapper.readValue(jsonStr, clazz);
  }
}
