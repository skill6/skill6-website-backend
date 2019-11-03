package cn.skill6.website.service.article;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.article.ArticleSvc;
import cn.skill6.website.dao.intf.article.ArticleDao;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章信息代理服务类，处理Controller转发过来的RestFul请求
 *
 * @author 何明胜
 * @since 2018年8月21日 下午11:07:30
 */
@Slf4j
@Service
@Component
public class ArticleService implements ArticleSvc {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public long addArticle(ArticleInfo articleInfo) {
        return articleDao.addArticleInfo(articleInfo);
    }

    @Override
    public int deleteArticleById(Long articleId) {
        return articleDao.deleteByPrimaryKey(articleId);
    }

    @Override
    public ResponseJson modifyArticleById(ArticleInfo articleInfo) {
        articleDao.modifyByArticleId(articleInfo);
        return ResponseJson.build("修改成功");
    }

    @Override
    public ArticleInfo getArticleById(Long articleId) {
        return articleDao.findByArticleId(articleId);
    }

    @Override
    public List<ArticleInfo> getAllArticles() {
        return articleDao.findAll();
    }

    @Override
    public PageResult<ArticleInfo> getArticlesByPage(int pageSize, int pageNum) {
        PageSortParam pageSortParam = PageSortParam.builder()
            .pageSize(10)
            .pageNum(1)
            .orderBy("article_create_time")
            .sortType(SortType.DESCENDING).build();

        Page<ArticleInfo> page = PageHelper.startPage(pageNum, pageSize);
        List<ArticleInfo> articleInfos = articleDao.findByParamWithPage(new ArticleInfo(), pageSortParam);

        return new PageResult<>(page.getTotal(), pageSize, pageNum, articleInfos);
    }
}
