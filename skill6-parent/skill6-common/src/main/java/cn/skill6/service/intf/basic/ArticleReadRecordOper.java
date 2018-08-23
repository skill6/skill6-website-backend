package cn.skill6.service.intf.basic;

import java.util.List;

import cn.skill6.common.entity.po.ArticleReadRecord;

/**
 * 文章阅读记录操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:27:47
 */
public interface ArticleReadRecordOper {
  int deleteByArtilceId(String artilceId);

  int addArticleReadRecord(ArticleReadRecord articleReadRecord);

  ArticleReadRecord findByArticleId(String artilceId);

  List<ArticleReadRecord> findAll();

  int updateByArtilceId(ArticleReadRecord articleReadRecord);
}
