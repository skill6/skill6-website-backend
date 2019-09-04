package cn.skill6.website.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 整合Spring Boot与Skill6配置
 *
 * @author liujichun
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月21日 下午9:58:13
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "skill6")
public class Skill6PropertyConfig {

    /**
     * 图片存储路径
     */
    private String imagePath = "image/";

    /**
     * 文件存储路径
     */
    private String filePath = "file/";

    /**
     * 分布式id相关配置
     */
    private Sequence sequence;

    private Recaptcha recaptcha;

    /**
     * github授权配置
     */
    private GitHub gitHub;

    /**
     * QQ授权配置
     */
    private QQ qq;

    @Data
    public static class Recaptcha {
        /**
         * Google reCaptcha私钥
         */
        private String secretKey;

        /**
         * Google reCaptcha验证URL
         */
        private String verifyUrl = "https://www.google.com/recaptcha/api/siteverify";
    }

    @Data
    public static class Sequence {

        private Worker worker;

        private DataCenter dataCenter;

        @Data
        public static class Worker {

            /**
             * 工作节点id
             */
            private String id = "0";
        }

        @Data
        public static class DataCenter {

            /**
             * 数据中心节点id
             */
            private String id = "0";
        }
    }

    @Data
    public static class GitHub {
        private String clientId;
        private String clientSecret;
        private String redirectUri;
    }

    @Data
    public static class QQ {
        private String clientId;
        private String clientSecret;
        private String redirectUri;
        private String scope;
        private String state;
    }
}
