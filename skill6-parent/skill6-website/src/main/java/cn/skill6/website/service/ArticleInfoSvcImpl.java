package cn.skill6.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.service.basic.ArticleInfoSvc;
import cn.skill6.website.dao.intf.ArticleInfoOper;

/**
 * 文章信息代理服务类，处理Controller转发过来的RestFul请求
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月21日 下午11:07:30
 */
@Service
public class ArticleInfoSvcImpl implements ArticleInfoSvc {

  @Autowired
  @Qualifier("articleInfoImpl")
  private ArticleInfoOper articleInfoOper;

  public ResponseJson addArticle(ArticleInfo articleInfo) {
    ResponseJson responseJson;
    try {
      Long articleId = articleInfoOper.addArticleInfo(articleInfo);
      responseJson = new ResponseJson(true, String.valueOf(articleId));
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "注册失败");
    }

    return responseJson;
  }

  public ResponseJson deleteArticleById(Long articleId) {
    articleInfoOper.deleteByPrimaryKey(articleId);
    return new ResponseJson(true, "删除成功");
  }

  public ResponseJson modifyArticleById(ArticleInfo articleInfo) {
    ResponseJson responseJson;

    try {
      articleInfoOper.modifyByArticleId(articleInfo);
      responseJson = new ResponseJson(true, "修改成功");
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "修改失败");
    }

    return responseJson;
  }

  public ResponseJson getArticleById(Long articleId) {
    ResponseJson responseJson;

    try {
      ArticleInfo articleInfo = articleInfoOper.findByArticleId(articleId);
      responseJson = new ResponseJson(true, articleInfo);
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "获取id为" + articleId + "的文章信息失败");
    }

    return responseJson;
  }

  public ResponseJson getAllArticles() {
    ResponseJson responseJson;

    try {
    	List<ArticleInfo> articleInfos = articleInfoOper.findAll();
      responseJson = new ResponseJson(true, articleInfos);
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "获取id所有文章信息失败");
    }

    return responseJson;
  }
}
