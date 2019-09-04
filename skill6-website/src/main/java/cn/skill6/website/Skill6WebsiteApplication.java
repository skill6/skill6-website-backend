package cn.skill6.website;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author 何明胜
 * @since 2018年8月21日 下午11:40:08
 */
@EnableDubbo
@EnableScheduling
@SpringBootApplication
@ComponentScan("cn.skill6")
@MapperScan(basePackages = {"cn.skill6.website.dao.mappers"})
public class Skill6WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(Skill6WebsiteApplication.class, args);
    }
}
