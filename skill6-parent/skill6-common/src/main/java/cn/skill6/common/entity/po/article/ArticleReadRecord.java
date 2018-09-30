package cn.skill6.common.entity.po.article;

import java.util.Date;

/**
 * 文章阅读记录实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:30:46
 */
public class ArticleReadRecord {
  private Long articleId;

  private Date articleDateDaily;

  private Integer articleReadDaily;

  @Override
  public String toString() {
    return "ArticleReadRecord [articleId="
        + articleId
        + ", articleDateDaily="
        + articleDateDaily
        + ", articleReadDaily="
        + articleReadDaily
        + "]";
  }

  public ArticleReadRecord(Long articleId, Date articleDateDaily, Integer articleReadDaily) {
    this.articleId = articleId;
    this.articleDateDaily = articleDateDaily;
    this.articleReadDaily = articleReadDaily;
  }

  public ArticleReadRecord() {
    super();
  }

  public Long getArticleId() {
    return articleId;
  }

  public void setArticleId(Long articleId) {
    this.articleId = articleId;
  }

  public Date getArticleDateDaily() {
    return articleDateDaily;
  }

  public void setArticleDateDaily(Date articleDateDaily) {
    this.articleDateDaily = articleDateDaily;
  }

  public Integer getArticleReadDaily() {
    return articleReadDaily;
  }

  public void setArticleReadDaily(Integer articleReadDaily) {
    this.articleReadDaily = articleReadDaily;
  }
}
