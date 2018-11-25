package cn.skill6.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * 测试启动类
 *
 * @author 何明胜
 * @author liujichun
 * @version 1.3
 * @since 2018年8月21日 下午11:40:08
 */
@SpringBootApplication
@ComponentScan("cn.skill6")
@MapperScan(basePackages = {"cn.skill6.website.dao.mappers"})
@EnableScheduling
@EnableDubbo
public class Skill6WebsiteApplication {

  public static void main(String[] args) {
    SpringApplication.run(Skill6WebsiteApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
