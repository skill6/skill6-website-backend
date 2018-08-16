package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ArticleInfo;
import java.util.List;

/**
 * 文章信息mapper
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:39:27
 * @version 1.0.0
 */
public interface ArticleInfoMapper {
  int deleteByPrimaryKey(Long articleId);

  int insert(ArticleInfo record);

  ArticleInfo selectByPrimaryKey(Long articleId);

  List<ArticleInfo> selectAll();

  int updateByPrimaryKey(ArticleInfo record);
}
