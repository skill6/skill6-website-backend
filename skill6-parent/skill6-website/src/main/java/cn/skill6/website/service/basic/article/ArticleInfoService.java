package cn.skill6.website.service.basic.article;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.microservice.basic.article.ArticleInfoSvc;
import cn.skill6.website.dao.intf.article.ArticleInfoDao;
import lombok.extern.slf4j.Slf4j;

/**
 * 文章信息代理服务类，处理Controller转发过来的RestFul请求
 *
 * @author 何明胜
 * @version 1.6
 * @since 2018年8月21日 下午11:07:30
 */
@Slf4j
@Service
@Component
public class ArticleInfoService implements ArticleInfoSvc {

  @Autowired private ArticleInfoDao articleInfoDao;

  public ResponseJson addArticle(ArticleInfo articleInfo) {
    ResponseJson responseJson;
    try {
      Long articleId = articleInfoDao.addArticleInfo(articleInfo);
      responseJson = new ResponseJson(true, String.valueOf(articleId));
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str(e));
      responseJson = new ResponseJson(false, "注册失败");
    }

    return responseJson;
  }

  public ResponseJson deleteArticleById(Long articleId) {
    articleInfoDao.deleteByPrimaryKey(articleId);
    return new ResponseJson(true, "删除成功");
  }

  public ResponseJson modifyArticleById(ArticleInfo articleInfo) {
    ResponseJson responseJson;

    try {
      articleInfoDao.modifyByArticleId(articleInfo);
      responseJson = new ResponseJson(true, "修改成功");
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str(e));
      responseJson = new ResponseJson(false, "修改失败");
    }

    return responseJson;
  }

  public ResponseJson getArticleById(Long articleId) {
    ResponseJson responseJson;

    try {
      ArticleInfo articleInfo = articleInfoDao.findByArticleId(articleId);
      responseJson = new ResponseJson(true, articleInfo);
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str(e));
      responseJson = new ResponseJson(false, "获取id为" + articleId + "的文章信息失败");
    }

    return responseJson;
  }

  public String getAllArticles() throws IOException {
    ResponseJson responseJson;

    try {
      List<ArticleInfo> articleInfos = articleInfoDao.findAll();
      responseJson = new ResponseJson(true, articleInfos);
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str(e));
      responseJson = new ResponseJson(false, "获取id所有文章信息失败");
    }

    return JacksonUtil.toStr(responseJson);
  }
}
