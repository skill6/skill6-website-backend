package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 点赞记录实体类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:36:36
 */
public class ThumbsUpRecord {
  private String userId;

  private String articleId;

  private String thumbsUpType;

  private Date thumbsUpDate;

  public ThumbsUpRecord(String userId, String articleId, String thumbsUpType, Date thumbsUpDate) {
    this.userId = userId;
    this.articleId = articleId;
    this.thumbsUpType = thumbsUpType;
    this.thumbsUpDate = thumbsUpDate;
  }

  public ThumbsUpRecord() {
    super();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId.trim();
  }

  public String getArticleId() {
    return articleId;
  }

  public void setArticleId(String articleId) {
    this.articleId = articleId == null ? null : articleId.trim();
  }

  public String getThumbsUpType() {
    return thumbsUpType;
  }

  public void setThumbsUpType(String thumbsUpType) {
    this.thumbsUpType = thumbsUpType == null ? null : thumbsUpType.trim();
  }

  public Date getThumbsUpDate() {
    return thumbsUpDate;
  }

  public void setThumbsUpDate(Date thumbsUpDate) {
    this.thumbsUpDate = thumbsUpDate;
  }
}
