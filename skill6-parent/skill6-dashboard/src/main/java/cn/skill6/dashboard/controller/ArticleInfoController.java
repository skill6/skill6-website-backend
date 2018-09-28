package cn.skill6.dashboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.microservice.basic.article.ArticleInfoSvc;

/**
 * dubbo 文章测试
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月29日 上午1:25:05
 */
@RestController
public class ArticleInfoController {
  @Reference ArticleInfoSvc articleInfoSvc;

  @RequestMapping(value = "/")
  @ResponseBody
  public ResponseJson getAll() {
    return articleInfoSvc.getAllArticles();
  }
}
