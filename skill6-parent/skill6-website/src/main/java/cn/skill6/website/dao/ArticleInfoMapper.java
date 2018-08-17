package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ArticleInfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文章信息mapper
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:39:27
 * @version 1.0.0
 */
@Mapper
public interface ArticleInfoMapper {
  int deleteByPrimaryKey(Long articleId);

  int insert(ArticleInfo articleInfo);

  ArticleInfo selectByPrimaryKey(Long articleId);

  List<ArticleInfo> selectAll();

  int updateByPrimaryKey(ArticleInfo articleInfo);
}
