package cn.skill6.common.entity.po.article;

import java.util.Date;

/**
 * 文章评论实体类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:29:03
 */
public class ArticleComment {
  private Long commentId;

  private String commentArticleId;

  private String commentUserId;

  private Long commentParentId;

  private Date commentDate;

  private Boolean commentValid;

  private String commentContent;

  @Override
  public String toString() {
    return "ArticleComment [commentId="
        + commentId
        + ", commentArticleId="
        + commentArticleId
        + ", commentUserId="
        + commentUserId
        + ", commentParentId="
        + commentParentId
        + ", commentDate="
        + commentDate
        + ", commentValid="
        + commentValid
        + ", commentContent="
        + commentContent
        + "]";
  }

  public ArticleComment(
      Long commentId,
      String commentArticleId,
      String commentUserId,
      Long commentParentId,
      Date commentDate,
      Boolean commentValid,
      String commentContent) {
    this.commentId = commentId;
    this.commentArticleId = commentArticleId;
    this.commentUserId = commentUserId;
    this.commentParentId = commentParentId;
    this.commentDate = commentDate;
    this.commentValid = commentValid;
    this.commentContent = commentContent;
  }

  public ArticleComment() {
    super();
  }

  public Long getCommentId() {
    return commentId;
  }

  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }

  public String getCommentArticleId() {
    return commentArticleId;
  }

  public void setCommentArticleId(String commentArticleId) {
    this.commentArticleId = commentArticleId == null ? null : commentArticleId.trim();
  }

  public String getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(String commentUserId) {
    this.commentUserId = commentUserId == null ? null : commentUserId.trim();
  }

  public Long getCommentParentId() {
    return commentParentId;
  }

  public void setCommentParentId(Long commentParentId) {
    this.commentParentId = commentParentId;
  }

  public Date getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(Date commentDate) {
    this.commentDate = commentDate;
  }

  public Boolean getCommentValid() {
    return commentValid;
  }

  public void setCommentValid(Boolean commentValid) {
    this.commentValid = commentValid;
  }

  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent == null ? null : commentContent.trim();
  }
}
