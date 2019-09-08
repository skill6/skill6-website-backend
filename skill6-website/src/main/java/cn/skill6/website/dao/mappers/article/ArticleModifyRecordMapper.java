package cn.skill6.website.dao.mappers.article;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章历史版本操作接口
 *
 * @author 何明胜
 * @since 2018年8月28日 上午1:25:19
 */
@Repository
public interface ArticleModifyRecordMapper {
    int deleteByPrimaryKey(Long articleModifyId);

    int insert(ArticleModifyRecord articleModifyRecord);

    ArticleModifyRecord selectByPrimaryKey(Long articleModifyId);

    List<ArticleModifyRecord> selectAll();

    int updateByPrimaryKey(ArticleModifyRecord articleModifyRecord);
}