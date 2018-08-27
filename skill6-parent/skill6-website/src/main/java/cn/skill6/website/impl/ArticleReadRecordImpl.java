package cn.skill6.website.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ArticleReadRecord;
import cn.skill6.service.intf.basic.ArticleReadRecordOper;
import cn.skill6.website.dao.ArticleReadRecordMapper;

/**
 * 文章阅读记录操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:17:12
 */
public class ArticleReadRecordImpl implements ArticleReadRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(ArticleReadRecordImpl.class);

  @Autowired private ArticleReadRecordMapper articleReadRecordMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#deleteByArtilceId(java.lang.String)
   */
  @Override
  public int deleteByArtilceId(Long articleId) {
    logger.warn("删除id为{}的文章阅读记录", articleId);
    
    return articleReadRecordMapper.deleteByPrimaryKey(articleId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#addArticleReadRecord(cn.skill6.common.entity.po.ArticleReadRecord)
   */
  @Override
  public int addArticleReadRecord(ArticleReadRecord articleReadRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#findByArticleId(java.lang.String)
   */
  @Override
  public ArticleReadRecord findByArticleId(Long artilceId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#findAll()
   */
  @Override
  public List<ArticleReadRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#updateByArtilceId(cn.skill6.common.entity.po.ArticleReadRecord)
   */
  @Override
  public int updateByArtilceId(ArticleReadRecord articleReadRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
