package cn.skill6.website.dao.mappers.article;

import cn.skill6.common.entity.po.article.ArticleModifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 文章历史版本操作接口
 *
 * @author 何明胜
 * @since 2018年8月28日 上午1:25:19
 */
public interface ArticleModifyRecordMapper {
    int deleteByPrimaryKey(
            @Param("articleId") Long articleId, @Param("articleUpdateTime") Date articleUpdateTime);

    int insert(ArticleModifyRecord articleModifyRecord);

    ArticleModifyRecord selectByPrimaryKey(Long articleId);

    List<ArticleModifyRecord> selectAll();

    int updateByPrimaryKey(ArticleModifyRecord articleModifyRecord);
}
