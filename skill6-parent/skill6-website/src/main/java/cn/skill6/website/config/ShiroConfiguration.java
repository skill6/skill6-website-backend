package cn.skill6.website.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.config.Ini;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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

  // 权限管理，配置主要是Realm的管理认证
  @Bean
  public org.apache.shiro.mgt.SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

    // TODO - 完善
    // 设置realm.
    // securityManager.setRealm(myShiroRealm());
    // 自定义缓存实现 使用redis
    // securityManager.setCacheManager(cacheManager());
    // 自定义session管理 使用redis
    // securityManager.setSessionManager(sessionManager());
    // 注入记住我管理器;
    // securityManager.setRememberMeManager(rememberMeManager());

    return securityManager;
  }

  /**
   * 过滤器
   *
   * @return 过滤链定义
   */
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(
      org.apache.shiro.mgt.SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);

    // 首页
    shiroFilterFactoryBean.setSuccessUrl(successUrl);
    // 登录
    shiroFilterFactoryBean.setLoginUrl(loginUrl);
    // 错误页面，认证不通过跳转
    shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

    return shiroFilterFactoryBean;
  }

  // 加入注解的使用，不加入这个注解不生效
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
      org.apache.shiro.mgt.SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
        new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }

  /** 设置自定义的URL配置文件 */
  @Bean
  public void setFilterChainDefinitionsLocation(ShiroFilterFactoryBean shiroFilterFactoryBean) {
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
    shiroFilterFactoryBean.setFilterChainDefinitionMap(section);
  }
}
