package cn.skill6.website.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.CredentialsMatcher;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import cn.skill6.website.security.credentials.RetryLimitCredentialsMatcher;
import cn.skill6.website.security.filter.Skill6AuthenticationFilter;
import cn.skill6.website.security.realm.auth.EmailRealm;
import cn.skill6.website.security.realm.auth.PhoneRealm;
import cn.skill6.website.security.realm.auth.UserNameRealm;
import cn.skill6.website.security.realm.oauth.GitHubRealm;
import cn.skill6.website.security.realm.oauth.GoogleRealm;
import cn.skill6.website.security.realm.oauth.QQRealm;
import cn.skill6.website.security.realm.oauth.WeChatRealm;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于进行Shiro配置
 *
 * @author liujichun
 * @author 何明胜
 * @version 1.3
 */
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfiguration {

  @Setter private String loginUrl;
  @Setter private String successUrl;
  @Setter private String unauthorizedUrl;

  /** shiro配置文件位置 */
  private String configPath = "classpath:config/shiro-urls.ini";

  /** session id生成器 */
  @Autowired SessionIdGenerator sessionIdGenerator;

  @Autowired CacheManager cacheManager;

  @Autowired PhoneRealm phoneRealm;
  @Autowired EmailRealm emailRealm;
  @Autowired UserNameRealm userNameRealm;

  @Autowired QQRealm qqRealm;
  @Autowired GitHubRealm gitHubRealm;
  @Autowired GoogleRealm googleRealm;
  @Autowired WeChatRealm weChatRealm;

  @Autowired Skill6AuthenticationFilter skill6AuthenticationFilter;

  /** 密码匹配器 */
  @Bean
  public CredentialsMatcher hashedCredentialsMatcher() {
    RetryLimitCredentialsMatcher credentialsMatcher =
        new RetryLimitCredentialsMatcher(cacheManager);

    credentialsMatcher.setHashAlgorithmName("md5");
    credentialsMatcher.setHashIterations(2);
    credentialsMatcher.setStoredCredentialsHexEncoded(true);

    return credentialsMatcher;
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
    sessionDAO.setSessionIdGenerator(sessionIdGenerator);

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

    // 添加所有的realm
    List<Realm> realms =
        Arrays.asList(
            userNameRealm, phoneRealm, emailRealm, gitHubRealm, googleRealm, qqRealm, weChatRealm);
    securityManager.setRealms(realms);

    // 自定义缓存实现 使用redis
    securityManager.setCacheManager(cacheManager);
    // 自定义session管理
    securityManager.setSessionManager(sessionManager());
    // 注入记住我管理器;
    securityManager.setRememberMeManager(rememberMeManager());

    return securityManager;
  }

  /**
   * 注入安全管理
   *
   * @param securityManager 安全管理器
   */
  @Bean
  public MethodInvokingFactoryBean methodInvokingFactoryBean(SecurityManager securityManager) {
    MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
    methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
    methodInvokingFactoryBean.setArguments(securityManager);

    return methodInvokingFactoryBean;
  }

  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);

    shiroFilterFactoryBean.setLoginUrl(loginUrl);
    shiroFilterFactoryBean.setSuccessUrl(successUrl);
    shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

    // 设置过滤器
    Map<String, Filter> filters = new HashMap<String, Filter>(3);
    filters.put("authc", skill6AuthenticationFilter);
    // filters.put("perms", value);
    // .put("logout", logoutUrl);
    shiroFilterFactoryBean.setFilters(filters);

    setFilterChainDefinitionsLocation(shiroFilterFactoryBean);

    return shiroFilterFactoryBean;
  }

  /** 设置自定义的URL配置文件 */
  private void setFilterChainDefinitionsLocation(ShiroFilterFactoryBean shiroFilterFactoryBean) {
    log.debug("start to load url config file...");
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
      log.debug("url config file's url section is empty");
      section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
    }

    // 设置URL到过滤链
    shiroFilterFactoryBean.setFilterChainDefinitionMap(section);
    log.debug("load url config file finished!");
  }
}
