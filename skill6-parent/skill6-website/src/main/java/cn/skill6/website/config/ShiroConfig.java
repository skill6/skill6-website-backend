package cn.skill6.website.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于进行Shiro配置
 *
 * @author liujichun
 * @version 1.0.1
 */
@Configuration
public class ShiroConfig {

  @Bean
  public Realm realm() {
    return new SimpleAccountRealm();
  }

  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
    chainDefinition.addPathDefinition("/**", "anon");
    return chainDefinition;
  }
}
