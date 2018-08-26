package cn.skill6.website.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.service.intf.basic.ArticleInfoOper;

/**
 * 文章信息代理服务类，处理Controller转发过来的RestFul请求
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月21日 下午11:07:30
 */
@Service
public class ArticleInfoSvc {
  private static final Logger logger = LoggerFactory.getLogger(ArticleInfoSvc.class);

  @Autowired
  @Qualifier("articleInfoImpl")
  private ArticleInfoOper articleInfoOper;

  /**
   * 添加新文章
   *
   * @param jsonMap
   * @return
   * @throws Skill6Exception
   * @throws IOException
   */
  public ResponseJson addArticle(ArticleInfo articleInfo) throws Skill6Exception, IOException {
    ResponseJson responseJson;

    try {
      Long articleId = articleInfoOper.addArticleInfo(articleInfo);
      responseJson = new ResponseJson(true, String.valueOf(articleId));
      logger.error("注册成功，id为{}", articleId);
    } catch (Exception e) {
      logger.error(StackTrace2Str.exceptionStackTrace2Str("注册失败", e));

      responseJson = new ResponseJson(false, "注册失败");
    }

    return responseJson;
  }

  /**
   * 根据id删除文章
   *
   * @param articleId
   * @return
   * @throws Skill6Exception
   */
  public ResponseJson deleteArticleById(Long articleId) throws Skill6Exception {
    articleInfoOper.deleteByPrimaryKey(articleId);

    logger.error("删除成功");
    return new ResponseJson(true, "删除成功");
  }

  /**
   * 根据id修改文章
   *
   * @param jsonMap
   * @return
   * @throws Skill6Exception
   * @throws IOException
   */
  public ResponseJson modifyArticleById(ArticleInfo articleInfo)
      throws Skill6Exception, IOException {
    ResponseJson responseJson;

    try {
      articleInfoOper.modifyByArticleId(articleInfo);
      logger.error("修改文章成功");
      responseJson = new ResponseJson(false, "修改成功");
    } catch (Exception e) {
      logger.error(StackTrace2Str.exceptionStackTrace2Str("修改文章失败", e));
      responseJson = new ResponseJson(false, "修改失败");
    }

    return responseJson;
  }

  /**
   * 根据id获取文章
   *
   * @param articleId
   * @return
   * @throws Skill6Exception
   */
  public ArticleInfo getArticleById(Long articleId) throws Skill6Exception {
    ArticleInfo articleInfo = articleInfoOper.findByArticleId(articleId);

    logger.error("获取文章成功，文章信息为{}", articleInfo);

    return articleInfo;
  }

  /**
   * 获取所有文章
   *
   * @return
   */
  public List<ArticleInfo> getAllArticles() {
    List<ArticleInfo> articleInfos = articleInfoOper.findAll();

    logger.error("获取文章列表成功，文章信息为{}", articleInfos);

    return articleInfos;
  }
}
