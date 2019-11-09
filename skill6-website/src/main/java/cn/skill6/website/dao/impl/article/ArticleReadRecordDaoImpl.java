package cn.skill6.website.dao.impl.article;

import cn.skill6.common.entity.po.article.ArticleReadRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.website.dao.intf.article.ArticleReadRecordDao;
import cn.skill6.website.dao.mappers.article.ArticleReadRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 文章阅读记录操作实现类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月28日 上午12:17:12
 */
@Slf4j
@Repository
public class ArticleReadRecordDaoImpl implements ArticleReadRecordDao {

    @Autowired
    private ArticleReadRecordMapper articleReadRecordMapper;

    @Override
    public int deleteByPrimaryKey(Long articleId, Date articleDateDaily) {
        log.warn("删除id为{},日期为{}的文章阅读记录", articleId, articleDateDaily);

        return articleReadRecordMapper.deleteByPrimaryKey(articleId, articleDateDaily);
    }

    @Override
    public Long addArticleReadRecord(ArticleReadRecord articleReadRecord) {
        long articleId = SequenceManager.getNextId();
        articleReadRecord.setArticleId(articleId);

        // 设置当天日期
        articleReadRecord.setArticleDateDaily(new Date());
        // 每天初始阅读量为0
        articleReadRecord.setArticleReadDaily(0);

        articleReadRecordMapper.insert(articleReadRecord);

        log.info("增加文章阅读记录成功,{}", articleReadRecord);

        return articleId;
    }

    @Override
    public ArticleReadRecord findByPrimaryKey(Long articleId, Date articleDateDaily) {
        ArticleReadRecord articleReadRecord =
                articleReadRecordMapper.selectByPrimaryKey(articleId, articleDateDaily);

        log.info("找到id为{}, 日期为{}的文章阅读记录,{}", articleId, articleDateDaily, articleReadRecord);

        return articleReadRecord;
    }

    @Override
    public List<ArticleReadRecord> findAll() {
        List<ArticleReadRecord> articleReadRecords = articleReadRecordMapper.selectAll();

        log.info("找到所有阅读记录,{}", articleReadRecords);

        return articleReadRecords;
    }

    @Override
    public int updateByArtilceId(ArticleReadRecord articleReadRecord) {
        throw new Skill6Exception("暂不支持此操作");
    }
}
