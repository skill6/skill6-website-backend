package cn.skill6.website.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ArticleModifyRecord;
import cn.skill6.service.intf.basic.ArticleModifyRecordOper;
import cn.skill6.website.dao.ArticleModifyRecordMapper;

/**
 * 文章历史版本操作实现类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午1:29:58
 */
public class ArticleModifyRecordImpl implements ArticleModifyRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(ArticleModifyRecordImpl.class);

  @Autowired private ArticleModifyRecordMapper articleModifyRecordMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#deleteByPrimaryKey(java.lang.Long)
   */
  @Override
  public int deleteByPrimaryKey(Long articleId, Date lastModifyDate) {
    logger.warn("删除id为{}的文章历史记录", articleId);

    return articleModifyRecordMapper.deleteByPrimaryKey(articleId, lastModifyDate);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#addArticleInfo(cn.skill6.common.entity.po.ArticleModifyRecord)
   */
  @Override
  public Long addArticleInfo(ArticleModifyRecord articleModifyRecord) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#findByArticleId(java.lang.Long)
   */
  @Override
  public ArticleModifyRecord findByArticleId(Long articleId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#findAll()
   */
  @Override
  public List<ArticleModifyRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#modifyByArticleId(cn.skill6.common.entity.po.ArticleModifyRecord)
   */
  @Override
  public void modifyByArticleId(ArticleModifyRecord articleModifyRecord) {
    // TODO Auto-generated method stub

  }
}
