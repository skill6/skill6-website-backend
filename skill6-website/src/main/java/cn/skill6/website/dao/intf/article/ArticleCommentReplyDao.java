package cn.skill6.website.dao.intf.article;

import cn.skill6.common.entity.po.article.ArticleCommentReply;

import java.util.List;

/**
 * 文章评论回复
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-11-10 15:22
 */
public interface ArticleCommentReplyDao {
    long insert(ArticleCommentReply articleCommentReply);

    List<ArticleCommentReply> selectAll();

    List<ArticleCommentReply> selectByParam(ArticleCommentReply articleCommentReply);
}
