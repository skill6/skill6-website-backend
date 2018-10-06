package cn.skill6.website;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

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
@MapperScan(basePackages = {"cn.skill6.website.dao"})
@EnableScheduling
@EnableDubbo
@Slf4j
public class Skill6WebsiteApplication {

  public static void main(String[] args) {
    SpringApplication.run(Skill6WebsiteApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /** 添加Chrome的驱动 */
  @Bean
  public WebDriver webDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments(
        "--headless", "--no-sandbox", "--disable-gpu", "--disable-dev-shm-usage");
    log.debug("chrome driver start with options {}", chromeOptions.asMap());
    return new ChromeDriver(chromeOptions);
  }
}
