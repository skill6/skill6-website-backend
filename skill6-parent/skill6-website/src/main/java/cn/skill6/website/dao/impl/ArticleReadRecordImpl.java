package cn.skill6.website.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ArticleReadRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.common.sequence.SequenceManager;
import cn.skill6.website.dao.ArticleReadRecordMapper;
import cn.skill6.website.dao.intf.ArticleReadRecordOper;

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
  public int deleteByPrimaryKey(Long articleId, Date articleDateDaily) {
    logger.warn("删除id为{},日期为{}的文章阅读记录", articleId, articleDateDaily);

    return articleReadRecordMapper.deleteByPrimaryKey(articleId, articleDateDaily);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#addArticleReadRecord(cn.skill6.common.entity.po.ArticleReadRecord)
   */
  @Override
  public Long addArticleReadRecord(ArticleReadRecord articleReadRecord) {
    Long articleId = SequenceManager.getNextId();
    if (articleId == null) {
      throw new NullPointerException("获取的articleId为空");
    }
    articleReadRecord.setArtilceId(articleId);

    // 设置当天日期
    articleReadRecord.setArticleDateDaily(new Date());
    // 每天初始阅读量为0
    articleReadRecord.setArticleReadDaily(0);

    articleReadRecordMapper.insert(articleReadRecord);

    logger.info("增加文章阅读记录成功,{}", articleReadRecord);

    return articleId;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#findByArticleId(java.lang.String)
   */
  @Override
  public ArticleReadRecord findByPrimaryKey(Long articleId, Date articleDateDaily) {
    ArticleReadRecord articleReadRecord =
        articleReadRecordMapper.selectByPrimaryKey(articleId, articleDateDaily);

    logger.info("找到id为{}, 日期为{}的文章阅读记录,{}", articleId, articleDateDaily, articleReadRecord);

    return articleReadRecord;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#findAll()
   */
  @Override
  public List<ArticleReadRecord> findAll() {
    List<ArticleReadRecord> articleReadRecords = articleReadRecordMapper.selectAll();

    logger.info("找到所有阅读记录,{}", articleReadRecords);

    return articleReadRecords;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleReadRecordOper#updateByArtilceId(cn.skill6.common.entity.po.ArticleReadRecord)
   */
  @Override
  public int updateByArtilceId(ArticleReadRecord articleReadRecord) {
    throw new Skill6Exception("暂不支持此操作");
  }
}
