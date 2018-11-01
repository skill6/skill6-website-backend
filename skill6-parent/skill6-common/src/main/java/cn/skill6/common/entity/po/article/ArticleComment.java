package cn.skill6.common.entity.po.article;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章评论实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:29:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleComment {

  @NotNull private Long commentId;

  private String commentArticleId;

  private String commentUserId;

  private Long commentParentId;

  private Date commentDate;

  private Boolean commentValid;

  private String commentContent;
}
