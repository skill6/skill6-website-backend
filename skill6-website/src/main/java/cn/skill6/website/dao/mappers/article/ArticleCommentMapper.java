package cn.skill6.website.dao.mappers.article;

import cn.skill6.common.entity.po.article.ArticleComment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章评论mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:38:54
 */
@Repository
public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(ArticleComment articleComment);

    ArticleComment selectByPrimaryKey(Long commentId);

    List<ArticleComment> selectAll();

    int updateByPrimaryKey(ArticleComment articleComment);

    List<ArticleComment> selectByParams(ArticleComment articleComment);
}
