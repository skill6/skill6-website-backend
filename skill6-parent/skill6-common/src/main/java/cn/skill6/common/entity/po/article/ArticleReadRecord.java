package cn.skill6.common.entity.po.article;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章阅读记录实体类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月15日 下午11:30:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleReadRecord {

  private Long articleId;

  private Date articleDateDaily;

  private Integer articleReadDaily;
}
