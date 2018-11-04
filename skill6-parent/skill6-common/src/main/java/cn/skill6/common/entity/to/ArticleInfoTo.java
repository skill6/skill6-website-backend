package cn.skill6.common.entity.to;

import java.util.Date;

import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.to.intf.BaseTemplate;
/**
 * 增加数据库实体类的字段模板类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年9月22日 上午11:55:06
 */
@Service
public class ArticleInfoTo extends ArticleInfo implements BaseTemplate {
  private static final long serialVersionUID = -6311863292986724660L;

  @Override
  public Date getArticleUpdateTime() {
    return super.getArticleUpdateTime();
  }

  @Override
  public Long getCategoryId() {
    return super.getCategoryId();
  }

  @Override
  public Long getArticleId() {
    return super.getArticleId();
  }

  @Override
  public String getArticleTitle() {
    return super.getArticleTitle();
  }

  @Override
  public String getArticleAuthor() {
    return super.getArticleAuthor();
  }

  @Override
  public String getArticleSummary() {
    return super.getArticleSummary();
  }

  @Override
  public String getArticleLabel() {
    return super.getArticleLabel();
  }

  @Override
  public Integer getArticleReadTotal() {
    return super.getArticleReadTotal();
  }

  @Override
  public Date getArticleCreateTime() {
    return super.getArticleCreateTime();
  }

  @Override
  public Boolean getArtilcePlaceTop() {
    return super.getArtilcePlaceTop();
  }

  @Override
  public Integer getArticleTopPriority() {
    return super.getArticleTopPriority();
  }

  @Override
  public Boolean getArticleAttachFile() {
    return super.getArticleAttachFile();
  }

  @Override
  public Boolean getArticleValid() {
    return super.getArticleValid();
  }

  @Override
  public String getArticleHtmlContent() {
    return super.getArticleHtmlContent();
  }

  @Override
  public String getArticleMdContent() {
    return super.getArticleMdContent();
  }

  @Override
  public String getArticleAttachUrl() {
    return super.getArticleAttachUrl();
  }

  @Override
  public boolean judgeFieldIsExist(String aimFieldName) {
    return judgeFieldIsExist(this.getClass(), aimFieldName);
  }
}
