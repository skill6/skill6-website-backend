package cn.skill6.website.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ArticleModifyRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.common.sequence.SequenceManager;
import cn.skill6.service.intf.basic.ArticleModifyRecordOper;
import cn.skill6.website.dao.ArticleModifyRecordMapper;

/**
 * 文章历史版本操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
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
  public Long addArticleModifyRecord(ArticleModifyRecord articleModifyRecord) {
    Long articleId = SequenceManager.getNextId();

    if (articleId == null) {
      throw new NullPointerException("获取的article为空");
    }
    // 设置主键
    articleModifyRecord.setArticleId(articleId);
    articleModifyRecord.setArticleLastModifyDate(new Date());

    articleModifyRecordMapper.insert(articleModifyRecord);

    logger.info("增加文章历史版本成功,{}", articleModifyRecord);

    return articleId;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#findByArticleId(java.lang.Long)
   */
  @Override
  public ArticleModifyRecord findByPrimaryKey(Long articleId, Date lastModifyDate) {
    ArticleModifyRecord articleModifyRecord =
        articleModifyRecordMapper.selectByPrimaryKey(articleId, lastModifyDate);

    logger.info("找到id为{}，最后修改日期为{}的文章历史版本，{}", articleId, lastModifyDate, articleModifyRecord);

    return articleModifyRecord;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#findAll()
   */
  @Override
  public List<ArticleModifyRecord> findAll() {
    List<ArticleModifyRecord> articleModifyRecords = articleModifyRecordMapper.selectAll();

    logger.info("找到所有历史文章，{}", articleModifyRecords);

    return articleModifyRecords;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ArticleModifyRecordOper#modifyByArticleId(cn.skill6.common.entity.po.ArticleModifyRecord)
   */
  @Override
  public void modifyByPrimaryKey(ArticleModifyRecord articleModifyRecord) {
    // 暂时不支持修改历史文章，历史文章本来就是文章的修改记录

    throw new Skill6Exception("暂不支持此操作");
  }
}
