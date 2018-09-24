package cn.skill6.website.dao.mappers.article;

import java.util.List;

import cn.skill6.common.entity.po.article.ArticleComment;

/**
 * 文章评论mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:38:54
 */
public interface ArticleCommentMapper {
  int deleteByPrimaryKey(Long commentId);

  int insert(ArticleComment articleComment);

  ArticleComment selectByPrimaryKey(Long commentId);

  List<ArticleComment> selectAll();

  int updateByPrimaryKey(ArticleComment articleComment);
}
