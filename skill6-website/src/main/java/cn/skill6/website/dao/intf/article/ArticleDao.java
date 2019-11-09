package cn.skill6.website.dao.intf.article;

import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.PageResult;

import java.util.List;

/**
 * 文章信息微服务接口
 *
 * @author 何明胜
 * @since 2018年8月16日 下午10:28:04
 */
public interface ArticleDao {

    int deleteByPrimaryKey(Long articleId);

    Long addArticleInfo(ArticleInfo articleInfo);

    ArticleInfo findByArticleId(Long articleId);

    List<ArticleInfo> findAll();

    void modifyByArticleId(ArticleInfo articleInfo);

    List<ArticleInfo> findByParams(ArticleInfo articleInfo);

    PageResult<ArticleInfo> findByParamWithPage(ArticleInfo articleInfo, PageSortParam pageSortParam);
}
