package cn.skill6.website.config;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.config.Ini;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 用于进行Shiro配置
 *
 * @author liujichun
 * @author 何明胜
 * @version 1.2
 */
@Configuration
public class ShiroConfig {

  @Autowired private Skill6Properties skill6Properties;

  @Autowired private org.apache.shiro.mgt.SecurityManager securityManager;

  @PostConstruct
  private void initStaticSecurityManager() {
    SecurityUtils.setSecurityManager(securityManager);
  }

  @Bean
  public Realm realm() {
    return new SimpleAccountRealm();
  }

  /**
   * 过滤器
   *
   * @return 过滤链定义
   */
  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    String filterChainDefinitionsLocation = skill6Properties.getShiro().getConfigPath();

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

    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
    chainDefinition.addPathDefinitions(section);

    return chainDefinition;
  }
}
