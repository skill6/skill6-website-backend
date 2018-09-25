package cn.skill6.website.dao.impl.article;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.to.ArticleInfoTo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.article.ArticleInfoDao;

/**
 * 文章信息实现测试
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年9月21日 下午11:24:25
 */
@SpringBootTest
@Transactional
public class ArticleInfoDaoOperTest extends Skill6WebsiteApplicationTest {

  @Resource(name = "articleInfoDaoOper")
  private ArticleInfoDao articleInfoDao;

  @Autowired private ArticleInfoTo articleInfoTo;

  @Test
  public void test01AddArticleInfo() {
    ArticleInfo articleInfo = new ArticleInfo();
    articleInfo.setArticleTitle("001");
    articleInfo.setArticleAuthor("liujichun");
    articleInfo.setArticleSummary("nihk");
    articleInfo.setArticleLabel("sldjfjk");
    articleInfo.setArticleCategoryId("123");
    articleInfo.setArticleHtmlContent("halsdfhj");
    articleInfo.setArticleMdContent("hkjhkj");
    articleInfoDao.addArticleInfo(articleInfo);
  }

  @Test
  public void testFindByParams() {
    ArticleInfo articleInfo = new ArticleInfo();
    articleInfo.setArticleAuthor("何明胜");

    // 根据哪个字段排序
    articleInfo.setOrderBy(articleInfoTo.getArticleAuthor());

    // 排序方式
    articleInfo.setSortType(SortType.DESCENDING);

    // 设置分页
    articleInfo.setPageNum(1);
    articleInfo.setPageSize(10);

    List<ArticleInfo> articleInfos = articleInfoDao.findByParams(articleInfo);

    for (ArticleInfo articleInfo2 : articleInfos) {
      System.out.println(articleInfo2.getArticleId());
    }

    assertTrue(articleInfos != null);
  }

  @Test
  public void test02ModifyByArticleId() {
    ArticleInfo articleInfo = new ArticleInfo();
    articleInfo.setArticleTitle("001");
    articleInfo.setArticleAuthor("liujichun");
    articleInfo.setArticleSummary("nihk");
    articleInfo.setArticleLabel("sldjfjk");
    articleInfo.setArticleCategoryId("123");
    articleInfo.setArticleHtmlContent("halsdfhj");
    articleInfo.setArticleMdContent("hkjhkj");
    Long id = articleInfoDao.addArticleInfo(articleInfo);
    articleInfo.setArticleId(id);
    articleInfoDao.modifyByArticleId(articleInfo);
  }

  @Test
  public void test01JudgeExist() {
    boolean judgeResult = articleInfoTo.judgeFieldIsExist("articleAuthor");
    assertTrue(judgeResult);
  }

  @Test
  public void test02JudgeExist() {
    boolean judgeResult = articleInfoTo.judgeFieldIsExist("articleAuthor1");
    assertFalse(judgeResult);
  }
}
