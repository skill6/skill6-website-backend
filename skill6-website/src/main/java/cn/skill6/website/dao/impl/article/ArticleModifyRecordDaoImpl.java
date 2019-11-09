package cn.skill6.website.dao.impl.article;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.website.dao.intf.article.ArticleModifyRecordDao;
import cn.skill6.website.dao.mappers.article.ArticleModifyRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 文章历史版本操作实现类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月28日 上午1:29:58
 */
@Slf4j
@Repository
public class ArticleModifyRecordDaoImpl implements ArticleModifyRecordDao {

    @Autowired
    private ArticleModifyRecordMapper articleModifyRecordMapper;

    @Override
    public int deleteByPrimaryKey(Long articleModifyId) {
        log.warn("删除id为{}的文章历史记录", articleModifyId);

        return articleModifyRecordMapper.deleteByPrimaryKey(articleModifyId);
    }

    @Override
    public long addArticleModifyRecord(ArticleModifyRecord articleModifyRecord) {
        long articleId = SequenceManager.getNextId();

        // 设置主键
        articleModifyRecord.setArticleId(articleId);
        articleModifyRecord.setArticleUpdateTime(new Date());

        articleModifyRecordMapper.insert(articleModifyRecord);

        log.info("增加文章历史版本成功,{}", articleModifyRecord);

        return articleId;
    }

    @Override
    public ArticleModifyRecord findByPrimaryKey(Long articleModifyId) {
        ArticleModifyRecord articleModifyRecord = articleModifyRecordMapper.selectByPrimaryKey(articleModifyId);

        log.info("找到id为{}的文章历史版本，{}", articleModifyId, articleModifyRecord);

        return articleModifyRecord;
    }

    @Override
    public List<ArticleModifyRecord> findAll() {
        List<ArticleModifyRecord> articleModifyRecords = articleModifyRecordMapper.selectAll();

        log.info("找到所有历史文章，{}", articleModifyRecords);

        return articleModifyRecords;
    }

    @Override
    public void modifyByPrimaryKey(ArticleModifyRecord articleModifyRecord) {
        // 暂时不支持修改历史文章，历史文章本来就是文章的修改记录

        throw new Skill6Exception("暂不支持此操作");
    }
}
