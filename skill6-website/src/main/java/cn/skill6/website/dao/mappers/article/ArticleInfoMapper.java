package cn.skill6.website.dao.mappers.article;

import cn.skill6.common.entity.po.article.ArticleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章信息mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:39:27
 */
@Repository
public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(ArticleInfo articleInfo);

    ArticleInfo selectByPrimaryKey(Long articleId);

    List<ArticleInfo> selectAll();

    int updateByPrimaryKey(ArticleInfo articleInfo);

    List<ArticleInfo> selectByParams(ArticleInfo articleInfo);
}
