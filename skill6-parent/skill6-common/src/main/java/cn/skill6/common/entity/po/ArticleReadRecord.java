package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 文章阅读记录实体类
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:30:46
 * @version 1.0.0
 */
public class ArticleReadRecord {
  private String artilceId;

  private Integer articleReadDaily;

  private Date articleDateDaily;

  public ArticleReadRecord(String artilceId, Integer articleReadDaily, Date articleDateDaily) {
    this.artilceId = artilceId;
    this.articleReadDaily = articleReadDaily;
    this.articleDateDaily = articleDateDaily;
  }

  public ArticleReadRecord() {
    super();
  }

  public String getArtilceId() {
    return artilceId;
  }

  public void setArtilceId(String artilceId) {
    this.artilceId = artilceId == null ? null : artilceId.trim();
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
