package cn.skill6.website.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.config.Ini;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import cn.skill6.website.cache.ShiroRedisCacheManager;
import cn.skill6.website.security.realm.UserNameRealm;
import cn.skill6.website.util.sequence.SequenceSessionIdGenerator;
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

  /** session id生成器 */
  @Bean
  public SessionIdGenerator sessionIdGenerator() {
    return new SequenceSessionIdGenerator();
  }

  @Bean
  public CacheManager cacheManager() {
    return new ShiroRedisCacheManager();
  }

  /** 密码匹配器 */
  @Bean
  public HashedCredentialsMatcher hashedCredentialsMatcher() {
    HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();

    credentialsMatcher.setHashAlgorithmName("md5");
    credentialsMatcher.setHashIterations(2);
    credentialsMatcher.setStoredCredentialsHexEncoded(true);

    return credentialsMatcher;
  }

  @Bean
  public Realm userNameRealm() {
    UserNameRealm userNameRealm = new UserNameRealm();

    userNameRealm.setCredentialsMatcher(hashedCredentialsMatcher());
    userNameRealm.setCachingEnabled(true);
    userNameRealm.setAuthenticationCachingEnabled(true);
    userNameRealm.setAuthenticationCacheName("authenticationCache");
    userNameRealm.setAuthorizationCachingEnabled(true);
    userNameRealm.setAuthorizationCacheName("authorizationCache");

    return userNameRealm;
  }

  @Bean
  public SimpleCookie sessionIdCookie() {
    SimpleCookie simpleCookie = new SimpleCookie("sessionId-cookie");

    simpleCookie.setMaxAge(2592000);
    simpleCookie.setPath("/");

    return simpleCookie;
  }

  @Bean
  public SimpleCookie rememberMeCookie() {
    SimpleCookie simpleCookie = new SimpleCookie("rememberMe-cookie");

    simpleCookie.setMaxAge(2592000);
    simpleCookie.setPath("/");

    return simpleCookie;
  }

  /** rememberMe管理器 */
  @Bean
  public CookieRememberMeManager rememberMeManager() {
    CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();

    cookieRememberMeManager.setCookie(rememberMeCookie());
    cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));

    return cookieRememberMeManager;
  }

  @Bean
  public SessionDAO sessionDAO() {
    EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();

    sessionDAO.setSessionIdGenerator(sessionIdGenerator());

    return sessionDAO;
  }

  @Bean
  public SessionManager sessionManager() {
    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

    sessionManager.setGlobalSessionTimeout(1000 * 60 * 60 * 24);
    sessionManager.setSessionDAO(sessionDAO());
    sessionManager.setSessionIdCookieEnabled(true);
    sessionManager.setSessionIdCookie(sessionIdCookie());

    return sessionManager;
  }

  /** 权限管理，配置主要是Realm的管理认证 */
  @Bean
  public DefaultWebSecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

    List<Realm> realms = Arrays.asList(userNameRealm());
    securityManager.setRealms(realms);

    // 自定义缓存实现 使用redis
    securityManager.setCacheManager(cacheManager());
    // 自定义session管理
    securityManager.setSessionManager(sessionManager());
    // 注入记住我管理器;
    securityManager.setRememberMeManager(rememberMeManager());

    return securityManager;
  }

  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

    shiroFilterFactoryBean.setSecurityManager(securityManager);

    shiroFilterFactoryBean.setLoginUrl(loginUrl);
    shiroFilterFactoryBean.setSuccessUrl(successUrl);
    shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

    setFilterChainDefinitionsLocation(shiroFilterFactoryBean);

    return shiroFilterFactoryBean;
  }

  /** 设置自定义的URL配置文件 */
  private void setFilterChainDefinitionsLocation(ShiroFilterFactoryBean shiroFilterFactoryBean) {
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
