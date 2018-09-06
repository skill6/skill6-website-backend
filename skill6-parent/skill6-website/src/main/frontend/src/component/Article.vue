<template>
  <div class="col-md-9 main">
    <h4>Java代码</h4>
    <hr>
    <MarkdownArea v-if="!article.article_html_content"
                  :md_content="article.article_md_content"></MarkdownArea>
    <p v-html="article.article_html_content"></p>
  </div>
</template>

<script>

  import MarkdownArea from "./MarkdownArea";

  export default {
    name: "Article",
    components: {MarkdownArea},
    data: function () {
      return {
        article: {
          article_md_content: "# skill6   [![building status](https://travis-ci.com/skill6/skill6.svg?branch=master)](https://travis-ci.com/skill6/skill6)  [![codecov](https://codecov.io/gh/skill6/skill6/branch/master/graph/badge.svg)](https://codecov.io/gh/skill6/skill6)\n\n技术流（skill6）网站的架构设计、需求分析、技术选型等\n\n------------\n \n### 1、架构设计\n\n ![image](https://github.com/CrazyHusen/skill6/blob/master/docs/%E6%9E%B6%E6%9E%84%E8%AE%BE%E8%AE%A1/skill6%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg?raw=true)\n\n------------\n"
          + "\n### 2、技术选型\n\n#### 2.1 后端\n技术 | 功能点 | 官网链接\n----|------|----\n"
          + "Maven | 项目依赖管理  | [http://maven.apache.org/](http://maven.apache.org/)\n"
          + "Spring | 容器 | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)\n"
          + "Spring Boot | spring框架 | [http://spring.io/projects/spring-boot](http://spring.io/projects/spring-boot)\n"
          + "SpringMVC | restful接口  | [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)\n"
          + "Shiro | 权限控制  | [http://shiro.apache.org/](http://shiro.apache.org/)\n"
          + "MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)\n"
          + "MyBatis Generator | 实体类和DAO代码生成  | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)\n"
          + "Druid | 数据库连接池  | [https://github.com/alibaba/druid](https://github.com/alibaba/druid)\n"
          + "Redis | 缓存  | [https://redis.io/](https://redis.io/)\n"
          + "Log4J | 日志  | [http://logging.apache.org/log4j/1.2/](http://logging.apache.org/log4j/1.2/)\n"
          + "Sequence | 分布式ID生产  | [http://git.oschina.net/yu120/sequence](http://git.oschina.net/yu120/sequence)\n"
          + "\n"
          + "#### 2.2 前端\n"
          + "技术 | 名称 | 官网\n"
          + "----|------|----\n"
          + "Vue.js | 构建用户界面的渐进式框架  | [https://cn.vuejs.org/](https://cn.vuejs.org/)\n"
          + "JQuery | 轻量级 JavaScript 库  | [http://jquery.com/](http://jquery.com/)\n"
          + "Bootstrap | 前端框架  | [http://getbootstrap.com/](http://getbootstrap.com/)\n"
          + "Editor.md | Markdown编辑器  | [https://github.com/pandao/editor.md](https://github.com/pandao/editor.md)\n"
          + "\n"
          + "#### 2.3 服务器\n"
          + "技术 | 名称 | 官网\n"
          + "----|------|----\n"
          + "Docker | 容器  | [https://www.docker.com/](https://www.docker.com/)\n"
          + "Nginx | 负载均衡  | [http://nginx.org/](http://nginx.org/)\n"
          + "\n"
          + "------------\n"
          + "\n"
          + "### 3、数据库设计\n"
          + "\n"
          + "![image](https://github.com/CrazyHusen/skill6/blob/master/docs/%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AE%BE%E8%AE%A1/%E6%95%B0%E6%8D%AE%E5%BA%93%E8%AE%BE%E8%AE%A1%E5%9B%BE.jpg?raw=true)\n"
          + "\n"
          + "**补充说明**\n"
          + "1. 目前已设计上述15个表，其中category_info表数据量较小，所以设计包含文章分类、代码分类等所有分类，通过type字段区别；\n"
          + "1. type（类型）字段使用枚举一一映射；\n"
          + "1. valid字段对应的tinyint只有1和0两个值，使用booealn值做映射；\n"
          + "1. id统一使用分布式id生成器生成，便于后期做分库分表，分布式id默认长度不超过19位，通过传入workedId和datacenterId两个参数即可生成；\n"
          + "1. 用户表包含管理用户和普通用户两种，通过type字段区分，用户表又分为用户重要信息（user_privacy_info）和其他信息（user_info）；\n"
          + "1. 图片和文件使用同一种方式存储，但是使用不同的表，因为图片数据量明显大于其他文件；\n"
          + "1. 文章评论和灌水区（类似主题问答）使用不同的表区分；\n"
          + "1. 文章和代码使用不同的表，文章包含文字+代码等，而代码是纯代码，如序列化工具类；\n"
          + "1. 用户修改信息、用户登录记录、用户访问网站和文章等的记录都详细记载，用于后期数据存储、分析和做推荐等；\n"
          + "1. 版本信息表用户更新网站版本说明及特性等；",
          article_html_content: null
        }
      }
    },
    methods: {
      getArticle: function () {
        $.ajax({
          url: "/article",
          method: "get",
          success: function (t) {
            console.log(t)
          }
        })
      }
    },
    mounted: function () {
      $('title').text('Java 代码');
    }
  }
</script>

<style scoped>
  .main {
    margin-top: 10px;
    background-color: white;
    padding: 10px;
  }
</style>