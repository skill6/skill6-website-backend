package cn.skill6.common.entity.po.article;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章评论实体类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月15日 下午11:29:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleComment {

  private Long commentId;

  private Long articleId;

  private Long userId;

  private Long commentParentId;

  private Date commentTime;

  private Boolean commentValid;

  private String commentContent;
}
