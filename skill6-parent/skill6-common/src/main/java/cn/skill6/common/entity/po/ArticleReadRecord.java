package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 文章阅读记录实体类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:30:46
 */
public class ArticleReadRecord {
  private Long articleId;

  private Integer articleReadDaily;

  private Date articleDateDaily;

  public ArticleReadRecord(Long articleId, Integer articleReadDaily, Date articleDateDaily) {
    this.articleId = articleId;
    this.articleReadDaily = articleReadDaily;
    this.articleDateDaily = articleDateDaily;
  }

  public ArticleReadRecord() {
    super();
  }

  public Long getArtilceId() {
    return articleId;
  }

  public void setArtilceId(Long articleId) {
    this.articleId = articleId;
  }

  public Integer getArticleReadDaily() {
    return articleReadDaily;
  }

  public void setArticleReadDaily(Integer articleReadDaily) {
    this.articleReadDaily = articleReadDaily;
  }

  public Date getArticleDateDaily() {
    return articleDateDaily;
  }

  public void setArticleDateDaily(Date articleDateDaily) {
    this.articleDateDaily = articleDateDaily;
  }
}
