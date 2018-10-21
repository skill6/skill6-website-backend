package cn.skill6.website.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 整合Spring Boot与Skill配置
 *
 * @author liujichun
 */
@ConfigurationProperties(prefix = "skill6")
@Configuration
@Data
public class Skill6Properties {

  /** 图片存储路径 */
  private String imagePath = "image/";

  /** 文件存储路径 */
  private String filePath = "file/";

  /** 分布式id相关配置 */
  private Sequence sequence;

  private Recaptcha recaptcha;

  /** shiro配置文件位置 */
  private Shiro shiro;

  @Data
  public static class Shiro {
    private String configPath = "classpath:config/shiro-urls.ini";
  }

  @Data
  public static class Recaptcha {
    /** Google reCaptcha私钥 */
    private String secretKey;

    /** Google reCaptcha验证URL */
    private String verifyUrl = "https://www.google.com/recaptcha/api/siteverify";
  }

  @Data
  public static class Sequence {

    private Worker worker;

    private DataCenter dataCenter;

    @Data
    public static class Worker {

      /** 工作节点id */
      private String id = "0";
    }

    @Data
    public static class DataCenter {

      /** 数据中心节点id */
      private String id = "0";
    }
  }
}
