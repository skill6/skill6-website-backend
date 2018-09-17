package cn.skill6.common.transform;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;

/**
 * 封装jackson转换为全局方法
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月26日 下午11:36:57
 */
public class JacksonUtil {
  // 驼峰和下划线格式自动转换
  private static final ObjectMapper objectMapper =
      new ObjectMapper().setPropertyNamingStrategy(SnakeCaseStrategy.SNAKE_CASE);

  public static ObjectMapper getInstance() {
    return objectMapper;
  }

  public static String toStr(Object object) throws IOException {
    return objectMapper.writeValueAsString(object);
  }

  public static <T> T map2Entity(Map<String, String> map, Class<T> clazz) throws IOException {
    return (T) objectMapper.convertValue(map, clazz);
  }

  @SuppressWarnings("unchecked")
  public static <T> Map<String, String> entity2Map(T entity) throws IOException {
    return entity2Entity(entity, Map.class);
  }

  public static <T, E> T entity2Entity(E entity, Class<T> clazz) throws IOException {
    return (T) objectMapper.convertValue(entity, clazz);
  }
}
