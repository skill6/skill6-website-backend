package cn.skill6.website.dao.mappers.article;

import java.util.List;

import cn.skill6.common.entity.po.article.ArticleInfo;

/**
 * 文章信息mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:39:27
 */
public interface ArticleInfoMapper {
  int deleteByPrimaryKey(Long articleId);

  int insert(ArticleInfo articleInfo);

  ArticleInfo selectByPrimaryKey(Long articleId);

  List<ArticleInfo> selectAll();

  int updateByPrimaryKey(ArticleInfo articleInfo);
  
  List<ArticleInfo> selectByParams(ArticleInfo articleInfo);
}
