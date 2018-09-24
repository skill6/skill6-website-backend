package cn.skill6.common.entity.po.feature;

import java.util.Date;

/**
 * 点赞记录实体类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:36:36
 */
public class FeatureThumbsUpRecord {
  private Long userId;

  private String articleId;

  private String thumbsUpType;

  private Date thumbsUpTime;

  @Override
  public String toString() {
    return "FeatureThumbsUpRecord [userId="
        + userId
        + ", articleId="
        + articleId
        + ", thumbsUpType="
        + thumbsUpType
        + ", thumbsUpTime="
        + thumbsUpTime
        + "]";
  }

  public FeatureThumbsUpRecord(
      Long userId, String articleId, String thumbsUpType, Date thumbsUpTime) {
    this.userId = userId;
    this.articleId = articleId;
    this.thumbsUpType = thumbsUpType;
    this.thumbsUpTime = thumbsUpTime;
  }

  public FeatureThumbsUpRecord() {
    super();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  public Date getThumbsUpTime() {
    return thumbsUpTime;
  }

  public void setThumbsUpTime(Date thumbsUpTime) {
    this.thumbsUpTime = thumbsUpTime;
  }
}
