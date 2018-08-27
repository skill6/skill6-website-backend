package cn.skill6.website.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ArticleComment;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.common.sequence.SequenceManager;
import cn.skill6.service.intf.basic.ArticleCommentOper;
import cn.skill6.website.dao.ArticleCommentMapper;

/**
 * 文章评论操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月27日 下午11:47:52
 */
public class ArticleCommentImpl implements ArticleCommentOper {

  private static final Logger logger = LoggerFactory.getLogger(ArticleCommentImpl.class);

  @Autowired private ArticleCommentMapper articleCommentMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleCommentOper#deleteByCommentId(java.lang.Long)
   */
  @Override
  public int deleteByCommentId(Long commentId) {
    logger.warn("删除id为{}的评论", commentId);
    return articleCommentMapper.deleteByPrimaryKey(commentId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleCommentOper#addArticleComment(cn.skill6.common.entity.po.ArticleComment)
   */
  @Override
  public Long addArticleComment(ArticleComment articleComment) {
    // 设置分布id
    Long commentId = SequenceManager.getNextId();
    if (commentId != null) {
      throw new NullPointerException("获取的Id为空");
    }
    articleComment.setCommentId(commentId);

    articleComment.setCommentDate(new Date());
    articleComment.setCommentValid(true);

    articleCommentMapper.insert(articleComment);

    logger.info("增加评论成功,{}", articleComment);

    return commentId;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleCommentOper#findByCommentId(java.lang.Long)
   */
  @Override
  public ArticleComment findByCommentId(Long commentId) {
    ArticleComment articleComment = articleCommentMapper.selectByPrimaryKey(commentId);

    logger.info("找到id为{}的评论,{}", commentId, articleComment);

    return articleComment;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleCommentOper#findAll()
   */
  @Override
  public List<ArticleComment> findAll() {
    List<ArticleComment> articleComments = articleCommentMapper.selectAll();

    logger.info("找到所有评论,{}", articleComments);

    return articleComments;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleCommentOper#modifyByCommentId(cn.skill6.common.entity.po.ArticleComment)
   */
  @Override
  public int modifyByCommentId(ArticleComment articleComment) {
    // TODO 暂不支持修改评论
    return 0;
  }
}
