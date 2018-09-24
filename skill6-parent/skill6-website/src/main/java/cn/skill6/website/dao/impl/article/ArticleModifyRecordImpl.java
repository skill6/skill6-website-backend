package cn.skill6.website.dao.impl.article;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.website.dao.intf.article.ArticleModifyRecordOper;
import cn.skill6.website.dao.mappers.article.ArticleModifyRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 文章历史版本操作实现类
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月28日 上午1:29:58
 */
public class ArticleModifyRecordImpl implements ArticleModifyRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(ArticleModifyRecordImpl.class);

  @Autowired private ArticleModifyRecordMapper articleModifyRecordMapper;

  @Override
  public int deleteByPrimaryKey(Long articleId, Date lastModifyDate) {
    logger.warn("删除id为{}的文章历史记录", articleId);

    return articleModifyRecordMapper.deleteByPrimaryKey(articleId, lastModifyDate);
  }

  @Override
  public Long addArticleModifyRecord(ArticleModifyRecord articleModifyRecord) {
    Long articleId = SequenceManager.getNextId();

    if (articleId == null) {
      throw new NullPointerException("获取的article为空");
    }
    // 设置主键
    articleModifyRecord.setArticleId(articleId);
    articleModifyRecord.setArticleLastModifyTime(new Date());

    articleModifyRecordMapper.insert(articleModifyRecord);

    logger.info("增加文章历史版本成功,{}", articleModifyRecord);

    return articleId;
  }

  @Override
  public ArticleModifyRecord findByPrimaryKey(Long articleId, Date lastModifyDate) {
    ArticleModifyRecord articleModifyRecord =
        articleModifyRecordMapper.selectByPrimaryKey(articleId, lastModifyDate);

    logger.info("找到id为{}，最后修改日期为{}的文章历史版本，{}", articleId, lastModifyDate, articleModifyRecord);

    return articleModifyRecord;
  }

  @Override
  public List<ArticleModifyRecord> findAll() {
    List<ArticleModifyRecord> articleModifyRecords = articleModifyRecordMapper.selectAll();

    logger.info("找到所有历史文章，{}", articleModifyRecords);

    return articleModifyRecords;
  }

  @Override
  public void modifyByPrimaryKey(ArticleModifyRecord articleModifyRecord) {
    // 暂时不支持修改历史文章，历史文章本来就是文章的修改记录

    throw new Skill6Exception("暂不支持此操作");
  }
}
