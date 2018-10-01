package cn.skill6.common.entity.po.article;

import java.util.Date;

/**
 * 文章历史版本实体类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年8月28日 上午1:25:48
 */
public class ArticleModifyRecord {
  private Long articleId;

  private Date articleLastModifyTime;

  private String articleTitle;

  private String articleAuthor;

  private String articleSummary;

  private String articleLabel;

  private Integer articleReadTotal;

  private Date articleCreateTime;

  private String articleCategoryId;

  private Boolean artilcePlaceTop;

  private Integer articleTopPriority;

  private Boolean articleAttachFile;

  private String articleHtmlContent;

  private String articleMdContent;

  private String articleAttachUrl;

  @Override
  public String toString() {
    return "ArticleModifyRecord [articleId="
        + articleId
        + ", articleLastModifyTime="
        + articleLastModifyTime
        + ", articleTitle="
        + articleTitle
        + ", articleAuthor="
        + articleAuthor
        + ", articleSummary="
        + articleSummary
        + ", articleLabel="
        + articleLabel
        + ", articleReadTotal="
        + articleReadTotal
        + ", articleCreateTime="
        + articleCreateTime
        + ", articleCategoryId="
        + articleCategoryId
        + ", artilcePlaceTop="
        + artilcePlaceTop
        + ", articleTopPriority="
        + articleTopPriority
        + ", articleAttachFile="
        + articleAttachFile
        + ", articleHtmlContent="
        + articleHtmlContent
        + ", articleMdContent="
        + articleMdContent
        + ", articleAttachUrl="
        + articleAttachUrl
        + "]";
  }

  public ArticleModifyRecord(
      Long articleId,
      Date articleLastModifyTime,
      String articleTitle,
      String articleAuthor,
      String articleSummary,
      String articleLabel,
      Integer articleReadTotal,
      Date articleCreateTime,
      String articleCategoryId,
      Boolean artilcePlaceTop,
      Integer articleTopPriority,
      Boolean articleAttachFile,
      String articleHtmlContent,
      String articleMdContent,
      String articleAttachUrl) {
    this.articleId = articleId;
    this.articleLastModifyTime = articleLastModifyTime;
    this.articleTitle = articleTitle;
    this.articleAuthor = articleAuthor;
    this.articleSummary = articleSummary;
    this.articleLabel = articleLabel;
    this.articleReadTotal = articleReadTotal;
    this.articleCreateTime = articleCreateTime;
    this.articleCategoryId = articleCategoryId;
    this.artilcePlaceTop = artilcePlaceTop;
    this.articleTopPriority = articleTopPriority;
    this.articleAttachFile = articleAttachFile;
    this.articleHtmlContent = articleHtmlContent;
    this.articleMdContent = articleMdContent;
    this.articleAttachUrl = articleAttachUrl;
  }

  public ArticleModifyRecord() {
    super();
  }

  public Long getArticleId() {
    return articleId;
  }

  public void setArticleId(Long articleId) {
    this.articleId = articleId;
  }

  public Date getArticleLastModifyTime() {
    return articleLastModifyTime;
  }

  public void setArticleLastModifyTime(Date articleLastModifyTime) {
    this.articleLastModifyTime = articleLastModifyTime;
  }

  public String getArticleTitle() {
    return articleTitle;
  }

  public void setArticleTitle(String articleTitle) {
    this.articleTitle = articleTitle == null ? null : articleTitle.trim();
  }

  public String getArticleAuthor() {
    return articleAuthor;
  }

  public void setArticleAuthor(String articleAuthor) {
    this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
  }

  public String getArticleSummary() {
    return articleSummary;
  }

  public void setArticleSummary(String articleSummary) {
    this.articleSummary = articleSummary == null ? null : articleSummary.trim();
  }

  public String getArticleLabel() {
    return articleLabel;
  }

  public void setArticleLabel(String articleLabel) {
    this.articleLabel = articleLabel == null ? null : articleLabel.trim();
  }

  public Integer getArticleReadTotal() {
    return articleReadTotal;
  }

  public void setArticleReadTotal(Integer articleReadTotal) {
    this.articleReadTotal = articleReadTotal;
  }

  public Date getArticleCreateTime() {
    return articleCreateTime;
  }

  public void setArticleCreateTime(Date articleCreateTime) {
    this.articleCreateTime = articleCreateTime;
  }

  public String getArticleCategoryId() {
    return articleCategoryId;
  }

  public void setArticleCategoryId(String articleCategoryId) {
    this.articleCategoryId = articleCategoryId == null ? null : articleCategoryId.trim();
  }

  public Boolean getArtilcePlaceTop() {
    return artilcePlaceTop;
  }

  public void setArtilcePlaceTop(Boolean artilcePlaceTop) {
    this.artilcePlaceTop = artilcePlaceTop;
  }

  public Integer getArticleTopPriority() {
    return articleTopPriority;
  }

  public void setArticleTopPriority(Integer articleTopPriority) {
    this.articleTopPriority = articleTopPriority;
  }

  public Boolean getArticleAttachFile() {
    return articleAttachFile;
  }

  public void setArticleAttachFile(Boolean articleAttachFile) {
    this.articleAttachFile = articleAttachFile;
  }

  public String getArticleHtmlContent() {
    return articleHtmlContent;
  }

  public void setArticleHtmlContent(String articleHtmlContent) {
    this.articleHtmlContent = articleHtmlContent == null ? null : articleHtmlContent.trim();
  }

  public String getArticleMdContent() {
    return articleMdContent;
  }

  public void setArticleMdContent(String articleMdContent) {
    this.articleMdContent = articleMdContent == null ? null : articleMdContent.trim();
  }

  public String getArticleAttachUrl() {
    return articleAttachUrl;
  }

  public void setArticleAttachUrl(String articleAttachUrl) {
    this.articleAttachUrl = articleAttachUrl == null ? null : articleAttachUrl.trim();
  }
}
