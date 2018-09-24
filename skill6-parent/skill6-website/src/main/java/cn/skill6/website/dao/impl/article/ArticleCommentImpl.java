package cn.skill6.website.dao.impl.article;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.website.dao.intf.article.ArticleCommentOper;
import cn.skill6.website.dao.mappers.article.ArticleCommentMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 文章评论操作实现类
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月27日 下午11:47:52
 */
public class ArticleCommentImpl implements ArticleCommentOper {

  private static final Logger logger = LoggerFactory.getLogger(ArticleCommentImpl.class);

  @Autowired private ArticleCommentMapper articleCommentMapper;

  @Override
  public int deleteByCommentId(Long commentId) {
    logger.warn("删除id为{}的评论", commentId);
    return articleCommentMapper.deleteByPrimaryKey(commentId);
  }

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

  @Override
  public ArticleComment findByCommentId(Long commentId) {
    ArticleComment articleComment = articleCommentMapper.selectByPrimaryKey(commentId);

    logger.info("找到id为{}的评论,{}", commentId, articleComment);

    return articleComment;
  }

  @Override
  public List<ArticleComment> findAll() {
    List<ArticleComment> articleComments = articleCommentMapper.selectAll();

    logger.info("找到所有评论,{}", articleComments);

    return articleComments;
  }

  @Override
  public int modifyByCommentId(ArticleComment articleComment) {
    // TODO 暂不支持修改评论
    return 0;
  }
}
