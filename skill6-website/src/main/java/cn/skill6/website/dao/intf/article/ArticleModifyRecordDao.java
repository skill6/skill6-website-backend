package cn.skill6.website.dao.intf.article;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;

import java.util.Date;
import java.util.List;

/**
 * 文章历史版本操作接口
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年8月28日 上午1:28:25
 */
public interface ArticleModifyRecordDao {
    int deleteByPrimaryKey(Long articleId, Date lastModifyDate);

    Long addArticleModifyRecord(ArticleModifyRecord articleModifyRecord);

    ArticleModifyRecord findByPrimaryKey(Long articleId, Date lastModifyDate);

    List<ArticleModifyRecord> findAll();

    void modifyByPrimaryKey(ArticleModifyRecord articleModifyRecord);
}
