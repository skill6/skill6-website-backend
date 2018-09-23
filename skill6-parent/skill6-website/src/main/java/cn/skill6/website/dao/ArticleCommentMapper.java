package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ArticleComment;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文章评论mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:38:54
 */
@Mapper
public interface ArticleCommentMapper {
  int deleteByPrimaryKey(Long commentId);

  int insert(ArticleComment articleComment);

  ArticleComment selectByPrimaryKey(Long commentId);

  List<ArticleComment> selectAll();

  int updateByPrimaryKey(ArticleComment articleComment);
}
