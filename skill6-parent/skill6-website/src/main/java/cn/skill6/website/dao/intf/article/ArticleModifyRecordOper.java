package cn.skill6.website.dao.intf.article;

import java.util.Date;
import java.util.List;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;

/**
 * 文章历史版本操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午1:28:25
 */
public interface ArticleModifyRecordOper {
  int deleteByPrimaryKey(Long articleId, Date lastModifyDate);

  Long addArticleModifyRecord(ArticleModifyRecord articleModifyRecord);

  ArticleModifyRecord findByPrimaryKey(Long articleId, Date lastModifyDate);

  List<ArticleModifyRecord> findAll();

  void modifyByPrimaryKey(ArticleModifyRecord articleModifyRecord);
}
