package cn.skill6.website.service.home;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.to.article.ArticleInfoTo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.dao.intf.article.ArticleDao;
import cn.skill6.website.home.RecommendSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 推荐服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 00:57
 */
@Slf4j
@Service
@Component
public class RecommendService implements RecommendSvc {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleInfoTo articleInfoTo;

    @Override
    public ResponseJson getRecommendCarousel() {
        return null;
    }

    @Override
    public ResponseJson getRecommendVideo() {
        return null;
    }

    @Override
    public ResponseJson getRecommendDownload() {
        return null;
    }

    @Override
    public ResponseJson getRecommendQuestion() {
        return null;
    }

    @Override
    public List<ArticleInfo> getRecommendArticle() {
        PageSortParam pageSortParam = PageSortParam.builder()
            .pageSize(10)
            .pageNum(1)
            .orderBy(articleInfoTo.getArticleCreateTime())
            .sortType(SortType.DESCENDING).build();

        PageResult<ArticleInfo> articleInfoPageResult = articleDao.findByParamWithPage(new ArticleInfo(), pageSortParam);

        return articleInfoPageResult.getData();
    }
}
