package cn.skill6.website.dao.intf.article;

import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.entity.vo.PageResult;

import java.util.List;

/**
 * 文章评论操作接口
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月24日 上午12:27:22
 */
public interface ArticleCommentDao {
    int deleteByCommentId(Long commentId);

    long addArticleComment(ArticleComment articleComment);

    ArticleComment findByCommentId(Long commentId);

    List<ArticleComment> findAll();

    PageResult<ArticleComment> findCommentsByPage(int pageSize, int pageNum);

    int modifyByCommentId(ArticleComment articleComment);

    PageResult<ArticleComment> getCommentsByArticleIdWithPage(
        ArticleComment articleComment, PageSortParam pageSortParam);
}
