package cn.skill6.common.transform;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;

/**
 * 封装jackson转换为全局方法
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月26日 下午11:36:57
 */
public class JacksonUtil {
  // 驼峰和下划线格式自动转换
  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .setPropertyNamingStrategy(SnakeCaseStrategy.SNAKE_CASE)
          .setDefaultPropertyInclusion(Include.NON_NULL);

  public static ObjectMapper getInstance() {
    return objectMapper;
  }

  public static String toStr(Object object) throws IOException {
    return objectMapper.writeValueAsString(object);
  }

  /**
   * entity包含实体类、Map、List等
   *
   * @param map
   * @param clazz
   * @throws IOException
   */
  public static <T> T map2Entity(Map<String, String> map, Class<T> clazz) throws IOException {
    return (T) objectMapper.convertValue(map, clazz);
  }

  @SuppressWarnings("unchecked")
  public static <T, E> Map<String, T> entity2Map(E entity) throws IOException {
    return entity2Entity(entity, Map.class);
  }

  /**
   * entity包含实体类、Map、List等
   *
   * @param entity
   * @param clazz
   * @throws IOException
   */
  public static <T, E> T entity2Entity(E entity, Class<T> clazz) throws IOException {
    return (T) objectMapper.convertValue(entity, clazz);
  }

  /**
   * entity包含实体类、Map、List等
   *
   * @param jsonStr
   * @param clazz
   * @throws IOException
   */
  public static <T, E> T str2Entity(String jsonStr, Class<T> clazz) throws IOException {
    return (T) objectMapper.readValue(jsonStr, clazz);
  }

  @SuppressWarnings("unchecked")
  public static <T> Map<String, T> str2Map(String jsonStr) throws IOException {
    return str2Entity(jsonStr, Map.class);
  }
}
