package cn.skill6.service.intf.basic;

import java.util.List;

import cn.skill6.common.entity.po.ArticleComment;

/**
 * 文章评论操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:27:22
 */
public interface ArticleCommentOper {
  int deleteByCommentId(Long commentId);

  int addArticleComment(ArticleComment articleComment);

  ArticleComment findByCommentId(Long commentId);

  List<ArticleComment> findAll();

  int modifyByCommentId(ArticleComment articleComment);
}
