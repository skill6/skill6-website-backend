package cn.skill6.common.entity.po.article;

import java.io.Serializable;
import java.util.Date;

import cn.skill6.common.entity.po.abst.PaginationAndSort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 文章信息实体类
 *
 * @author 何明胜
 * @version 1.7
 * @since 2018年8月15日 下午11:30:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleInfo extends PaginationAndSort implements Serializable {
  private static final long serialVersionUID = 1870286929298864677L;

  private Long articleId;

  private Long categoryId;

  private String articleTitle;

  private String articleAuthor;

  private String articleSummary;

  private String articleLabel;

  private Integer articleReadTotal;

  private Date articleCreateTime;

  private Date articleUpdateTime;

  private Boolean artilcePlaceTop;

  private Integer articleTopPriority;

  private Boolean articleAttachFile;

  private Boolean articleValid;

  private String articleHtmlContent;

  private String articleMdContent;

  private String articleAttachUrl;
}
