package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ArticleReadRecord;
import java.util.List;

/**
 * 文章阅读记录mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:39:38
 */
public interface ArticleReadRecordMapper {
  int deleteByPrimaryKey(Long articleId);

  int insert(ArticleReadRecord articleReadRecord);

  ArticleReadRecord selectByPrimaryKey(Long articleId);

  List<ArticleReadRecord> selectAll();

  int updateByPrimaryKey(ArticleReadRecord articleReadRecord);
}
