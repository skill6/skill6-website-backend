package cn.skill6.common.utility;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/** @Desc 获取web应用上下文 @Author 何明胜 @Created at @Version 1.0.0 */
/**
 * 获取web应用上下文
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年4月17日 下午1:13:11
 */
public class SpringContext {
  public static WebApplicationContext getContext() {
    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();

    return webApplicationContext;
  }
}
