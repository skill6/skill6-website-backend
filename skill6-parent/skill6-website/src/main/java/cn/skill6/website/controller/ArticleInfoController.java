package cn.skill6.website.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.common.entity.vo.restful.ResponseJson;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.transform.ConvertRequestParams;
import cn.skill6.website.service.ArticleInfoSvc;

/**
 * 文章信息控制器
 *
 * @author 何明胜
 * @created at 2018年8月16日 下午11:05:32
 * @version 1.0.0
 */
@Controller
public class ArticleInfoController {
  @Autowired private ArticleInfoSvc articleInfoSvc;

  @ResponseBody
  @RequestMapping(value = "/article", method = RequestMethod.POST)
  public ResponseJson addArticle(HttpServletRequest request) throws Skill6Exception, IOException {
    Map<String, String> jsonMap = ConvertRequestParams.params2Map(request);

    return articleInfoSvc.addArticle(jsonMap);
  }

  @ResponseBody
  @RequestMapping(value = "/article", method = RequestMethod.DELETE)
  public ResponseJson deleteArticleById(@RequestParam(value = "article_id") Long articleId)
      throws Skill6Exception {
    return articleInfoSvc.deleteArticleById(articleId);
  }

  @ResponseBody
  @RequestMapping(value = "/article", method = RequestMethod.PUT)
  public ResponseJson modifyByArticleId(HttpServletRequest request)
      throws Skill6Exception, IOException {
    Map<String, String> jsonMap = ConvertRequestParams.params2Map(request);

    return articleInfoSvc.modifyByArticleId(jsonMap);
  }

  @ResponseBody
  @RequestMapping(value = "/article", method = RequestMethod.GET)
  public ArticleInfo getArticleById(@RequestParam(value = "article_id") Long articleId)
      throws Skill6Exception {
    return articleInfoSvc.getArticleById(articleId);
  }

  @ResponseBody
  @RequestMapping(value = "/article/all", method = RequestMethod.GET)
  public List<ArticleInfo> getAllArticles() throws Skill6Exception {
    return articleInfoSvc.getAllArticles();
  }
}
