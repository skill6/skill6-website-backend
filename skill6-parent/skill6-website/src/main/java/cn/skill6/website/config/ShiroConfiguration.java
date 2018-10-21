package cn.skill6.website.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.config.Ini;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import lombok.Data;

/**
 * 用于进行Shiro配置
 *
 * @author liujichun
 * @author 何明胜
 * @version 1.2
 */
/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月22日 上午12:30:10
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfiguration {

  private String loginUrl;
  private String successUrl;
  private String unauthorizedUrl;

  /** shiro配置文件位置 */
  private String configPath = "classpath:config/shiro-urls.ini";

  @Bean
  public Realm realm() {
    return new SimpleAccountRealm();
  }

  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

    setFilterChainDefinitionsLocation(chainDefinition);

    return chainDefinition;
  }

  /** 设置自定义的URL配置文件 */
  public void setFilterChainDefinitionsLocation(
      DefaultShiroFilterChainDefinition shiroFilterChainDefinition) {
    String filterChainDefinitionsLocation = configPath;

    if (!StringUtils.hasText(filterChainDefinitionsLocation)) {
      throw new ConfigurationException("filterChainDefinitionsLocation can't be empty");
    }

    Ini ini = new Ini();
    try {
      InputStream is = ResourceUtils.getInputStreamForPath(filterChainDefinitionsLocation);

      if (is != null) {
        ini.load(is);
      } else {
        throw new ConfigurationException(
            "Unable to load shiro config path: " + filterChainDefinitionsLocation);
      }
      is.close();
    } catch (IOException e) {
      throw new ConfigurationException(e);
    }

    Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
    if (CollectionUtils.isEmpty(section)) {
      section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
    }

    // 设置URL到过滤链
    shiroFilterChainDefinition.addPathDefinitions(section);
  }
}
