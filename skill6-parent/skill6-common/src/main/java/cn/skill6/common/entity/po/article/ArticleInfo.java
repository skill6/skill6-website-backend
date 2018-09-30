package cn.skill6.common.entity.po.article;

import java.io.Serializable;
import java.util.Date;

import cn.skill6.common.entity.po.abst.PaginationAndSort;

/**
 * 文章信息实体类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月15日 下午11:30:31
 */
public class ArticleInfo extends PaginationAndSort implements Serializable {
  private static final long serialVersionUID = 1870286929298864677L;

  private Long articleId;

  private String articleTitle;

  private String articleAuthor;

  private String articleSummary;

  private String articleLabel;

  private Integer articleReadTotal;

  private Date articleCreateTime;

  private Date articleLastModifyTime;

  private String articleCategoryId;

  private Boolean artilcePlaceTop;

  private Integer articleTopPriority;

  private Boolean articleAttachFile;

  private Boolean articleValid;

  private String articleHtmlContent;

  private String articleMdContent;

  private String articleAttachUrl;

  @Override
  public String toString() {
    return "ArticleInfo [articleId="
        + articleId
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
        + ", articleLastModifyTime="
        + articleLastModifyTime
        + ", articleCategoryId="
        + articleCategoryId
        + ", artilcePlaceTop="
        + artilcePlaceTop
        + ", articleTopPriority="
        + articleTopPriority
        + ", articleAttachFile="
        + articleAttachFile
        + ", articleValid="
        + articleValid
        + ", articleHtmlContent="
        + articleHtmlContent
        + ", articleMdContent="
        + articleMdContent
        + ", articleAttachUrl="
        + articleAttachUrl
        + ", toString()="
        + super.toString()
        + "]";
  }

  public ArticleInfo(
      Long articleId,
      String articleTitle,
      String articleAuthor,
      String articleSummary,
      String articleLabel,
      Integer articleReadTotal,
      Date articleCreateTime,
      Date articleLastModifyTime,
      String articleCategoryId,
      Boolean artilcePlaceTop,
      Integer articleTopPriority,
      Boolean articleAttachFile,
      Boolean articleValid,
      String articleHtmlContent,
      String articleMdContent,
      String articleAttachUrl) {
    this.articleId = articleId;
    this.articleTitle = articleTitle;
    this.articleAuthor = articleAuthor;
    this.articleSummary = articleSummary;
    this.articleLabel = articleLabel;
    this.articleReadTotal = articleReadTotal;
    this.articleCreateTime = articleCreateTime;
    this.articleLastModifyTime = articleLastModifyTime;
    this.articleCategoryId = articleCategoryId;
    this.artilcePlaceTop = artilcePlaceTop;
    this.articleTopPriority = articleTopPriority;
    this.articleAttachFile = articleAttachFile;
    this.articleValid = articleValid;
    this.articleHtmlContent = articleHtmlContent;
    this.articleMdContent = articleMdContent;
    this.articleAttachUrl = articleAttachUrl;
  }

  public ArticleInfo() {
    super();
  }

  public Long getArticleId() {
    return articleId;
  }

  public void setArticleId(Long articleId) {
    this.articleId = articleId;
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

  public Date getArticleLastModifyTime() {
    return articleLastModifyTime;
  }

  public void setArticleLastModifyTime(Date articleLastModifyTime) {
    this.articleLastModifyTime = articleLastModifyTime;
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

  public Boolean getArticleValid() {
    return articleValid;
  }

  public void setArticleValid(Boolean articleValid) {
    this.articleValid = articleValid;
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
