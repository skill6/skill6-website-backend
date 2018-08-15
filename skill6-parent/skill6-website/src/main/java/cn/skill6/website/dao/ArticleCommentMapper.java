package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ArticleComment;
import java.util.List;

/**
 * 文章评论mapper
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:38:54
 * @version 1.0.0
 */
public interface ArticleCommentMapper {
  int deleteByPrimaryKey(Long commentId);

  int insert(ArticleComment record);

  ArticleComment selectByPrimaryKey(Long commentId);

  List<ArticleComment> selectAll();

  int updateByPrimaryKey(ArticleComment record);
}
