package cn.skill6.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.skill6"})
public class Skill6WebsiteApplication {

  public static void main(String[] args) {
    SpringApplication.run(Skill6WebsiteApplication.class, args);
  }

}
