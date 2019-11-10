package cn.skill6.website.dao.impl.article;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.to.article.ArticleInfoTo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.article.ArticleDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 文章信息实现测试
 *
 * @author 何明胜
 * @since 2018年9月21日 下午11:24:25
 */
@Transactional
public class ArticleDaoImplTest extends Skill6WebsiteApplicationTest {

    @Autowired
    private ArticleDao articleInfoDao;

    @Autowired
    private ArticleInfoTo articleInfoTo;

    @Test
    public void test01AddArticleInfo() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleTitle("001");
        articleInfo.setArticleAuthor("hemingsheng");
        articleInfo.setArticleSummary("asg");
        articleInfo.setArticleLabel("sdg");
        articleInfo.setCategoryId(123L);
        articleInfo.setArticleHtmlContent("gf");
        articleInfo.setArticleMdContent("hkjhkj");
        articleInfoDao.addArticleInfo(articleInfo);
    }

    @Test
    public void testFindByParams() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleAuthor("何明胜");

        List<ArticleInfo> articleInfos = articleInfoDao.findByParams(articleInfo);

        for (ArticleInfo articleInfo2 : articleInfos) {
            System.out.println(articleInfo2.getArticleId());
        }

        assertTrue(true);
    }

    @Test
    public void testFindByParamWithPage() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleAuthor("何明胜");

        PageSortParam pageSortParam = PageSortParam.builder()
            .pageSize(10)
            .pageNum(1)
            .orderBy(articleInfoTo.getArticleAuthor())
            .sortType(SortType.DESCENDING).build();

        PageResult<ArticleInfo> articleInfoPageResult = articleInfoDao.findByParamWithPage(articleInfo, pageSortParam);
        List<ArticleInfo> articleInfos = articleInfoPageResult.getData();

        for (ArticleInfo articleInfo2 : articleInfos) {
            System.out.println(articleInfo2.getArticleId());
        }

        assertEquals(articleInfos.size(), 10);
    }

    @Test
    public void test02ModifyByArticleId() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleTitle("001");
        articleInfo.setArticleAuthor("sfher");
        articleInfo.setArticleSummary("nihk");
        articleInfo.setArticleLabel("sldjfjk");
        articleInfo.setArticleId(123L);
        articleInfo.setArticleHtmlContent("halsdfhj");
        articleInfo.setArticleMdContent("hkjhkj");
        articleInfo.setCategoryId(123L);

        Long id = articleInfoDao.addArticleInfo(articleInfo);
        articleInfo.setArticleId(id);
        articleInfoDao.modifyByArticleId(articleInfo);
    }
}
