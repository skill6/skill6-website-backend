package cn.skill6.website.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 整合Spring Boot与Skill配置
 *
 * @author liujichun
 */
@ConfigurationProperties(prefix = "skill6")
@Configuration
public class Skill6Properties {

  /** 图片存储路径 */
  private String imagePath = "image/";

  /** 文件存储路径 */
  private String filePath = "file/";

  /** 分布式id相关配置 */
  private Sequence sequence;

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public Sequence getSequence() {
    return sequence;
  }

  public void setSequence(Sequence sequence) {
    this.sequence = sequence;
  }

  public static class Sequence {

    private Worker worker;

    private DataCenter dataCenter;

    public Worker getWorker() {
      return worker;
    }

    public void setWorker(Worker worker) {
      this.worker = worker;
    }

    public DataCenter getDataCenter() {
      return dataCenter;
    }

    public void setDataCenter(DataCenter dataCenter) {
      this.dataCenter = dataCenter;
    }

    public static class Worker {

      /** 工作节点id */
      private String id = "0";

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }
    }

    public static class DataCenter {

      /** 数据中心节点id */
      private String id = "0";

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }
    }
  }
}
