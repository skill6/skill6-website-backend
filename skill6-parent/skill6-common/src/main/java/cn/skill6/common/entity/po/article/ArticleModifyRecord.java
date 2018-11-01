package cn.skill6.common.entity.po.article;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章历史版本实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月28日 上午1:25:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
