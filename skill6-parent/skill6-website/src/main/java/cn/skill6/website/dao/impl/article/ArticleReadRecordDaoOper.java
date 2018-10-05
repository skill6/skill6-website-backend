package cn.skill6.website.dao.impl.article;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.article.ArticleReadRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.article.ArticleReadRecordDao;
import cn.skill6.website.dao.mappers.article.ArticleReadRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 文章阅读记录操作实现类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月28日 上午12:17:12
 */
public class ArticleReadRecordDaoOper implements ArticleReadRecordDao {
  private static final Logger logger = LoggerFactory.getLogger(ArticleReadRecordDaoOper.class);

  @Autowired private ArticleReadRecordMapper articleReadRecordMapper;

  @Override
  public int deleteByPrimaryKey(Long articleId, Date articleDateDaily) {
    logger.warn("删除id为{},日期为{}的文章阅读记录", articleId, articleDateDaily);

    return articleReadRecordMapper.deleteByPrimaryKey(articleId, articleDateDaily);
  }

  @Override
  public Long addArticleReadRecord(ArticleReadRecord articleReadRecord) {
    Long articleId = SequenceManager.getNextId();
    if (articleId == null) {
      throw new NullPointerException("获取的articleId为空");
    }
    articleReadRecord.setArticleId(articleId);

    // 设置当天日期
    articleReadRecord.setArticleDateDaily(new Date());
    // 每天初始阅读量为0
    articleReadRecord.setArticleReadDaily(0);

    articleReadRecordMapper.insert(articleReadRecord);

    logger.info("增加文章阅读记录成功,{}", articleReadRecord);

    return articleId;
  }

  @Override
  public ArticleReadRecord findByPrimaryKey(Long articleId, Date articleDateDaily) {
    ArticleReadRecord articleReadRecord =
        articleReadRecordMapper.selectByPrimaryKey(articleId, articleDateDaily);

    logger.info("找到id为{}, 日期为{}的文章阅读记录,{}", articleId, articleDateDaily, articleReadRecord);

    return articleReadRecord;
  }

  @Override
  public List<ArticleReadRecord> findAll() {
    List<ArticleReadRecord> articleReadRecords = articleReadRecordMapper.selectAll();

    logger.info("找到所有阅读记录,{}", articleReadRecords);

    return articleReadRecords;
  }

  @Override
  public int updateByArtilceId(ArticleReadRecord articleReadRecord) {
    throw new Skill6Exception("暂不支持此操作");
  }
}
