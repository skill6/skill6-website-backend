package cn.skill6.microservice.basic.article;

import java.io.IOException;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.exception.Skill6Exception;

/**
 * 微服务接口
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年9月4日 上午1:00:40
 */
public interface ArticleInfoSvc {
  /**
   * 添加新文章
   *
   * @param articleInfo
   */
  public ResponseJson addArticle(ArticleInfo articleInfo);

  /**
   * 根据id删除文章
   *
   * @param articleId
   */
  public ResponseJson deleteArticleById(Long articleId);

  /**
   * 根据id修改文章
   *
   * @param articleInfo
   */
  public ResponseJson modifyArticleById(ArticleInfo articleInfo);

  /**
   * 根据id获取文章
   *
   * @param articleId
   * @throws Skill6Exception
   */
  public ResponseJson getArticleById(Long articleId);

  /**
   * 获取所有文章
   *
   * @throws IOException
   */
  public String getAllArticles() throws IOException;
}
