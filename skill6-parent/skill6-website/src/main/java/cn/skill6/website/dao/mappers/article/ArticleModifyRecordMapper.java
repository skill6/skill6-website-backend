package cn.skill6.website.dao.mappers.article;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;

/**
 * 文章历史版本操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午1:25:19
 */
public interface ArticleModifyRecordMapper {
  int deleteByPrimaryKey(
      @Param("articleId") Long articleId,
      @Param("articleLastModifyTime") Date articleLastModifyTime);

  int insert(ArticleModifyRecord articleModifyRecord);

  ArticleModifyRecord selectByPrimaryKey(
      @Param("articleId") Long articleId,
      @Param("articleLastModifyTime") Date articleLastModifyTime);

  List<ArticleModifyRecord> selectAll();

  int updateByPrimaryKey(ArticleModifyRecord articleModifyRecord);
}
