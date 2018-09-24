package cn.skill6.website.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.to.ArticleInfoTo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.impl.article.ArticleInfoImpl;

/**
 * 文章信息实现测试
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月21日 下午11:24:25
 */
@SpringBootTest
@Transactional
public class ArticleInfoImplTest extends Skill6WebsiteApplicationTest {

  @Autowired private ArticleInfoImpl articleInfoOper;

  @Autowired
  @Qualifier("articleInfoTo")
  private ArticleInfoTo articleInfoTo;

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
    articleInfoOper.addArticleInfo(articleInfo);
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

    List<ArticleInfo> articleInfos = articleInfoOper.findByParams(articleInfo);

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
    Long id = articleInfoOper.addArticleInfo(articleInfo);
    articleInfo.setArticleId(id);
    articleInfoOper.modifyByArticleId(articleInfo);
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
