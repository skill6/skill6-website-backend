package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ArticleInfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文章信息mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:39:27
 */
@Mapper
public interface ArticleInfoMapper {
  int insert(ArticleInfo articleInfo);

  int deleteByPrimaryKey(Long articleId);

  int updateByPrimaryKey(ArticleInfo articleInfo);

  ArticleInfo selectByPrimaryKey(Long articleId);

  List<ArticleInfo> selectAll();
  
  List<ArticleInfo> selectByParams(ArticleInfo articleInfo);
}
