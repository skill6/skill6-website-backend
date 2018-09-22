package cn.skill6.website.dao.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.common.entity.to.ArticleInfoTo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.ArticleInfoOper;

/**
 * 文章信息实现测试
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月21日 下午11:24:25
 */
@SpringBootTest
public class ArticleInfoImplTest extends Skill6WebsiteApplicationTest {

  @Autowired
  @Qualifier("articleInfoImpl")
  private ArticleInfoOper articleInfoOper;

  @Autowired
  @Qualifier("articleInfoTo")
  private ArticleInfoTo articleInfoTo;

  @Test
  public void testFindByParams() {
    ArticleInfo articleInfo = new ArticleInfo();
    articleInfo.setArticleAuthor("何明胜");

    // 根据哪个字段排序
    articleInfo.setOrderBy(articleInfoTo.getArticleAuthor());
    // 排序方式
    articleInfo.setSortType(SortType.DESCENDING);

    List<ArticleInfo> articleInfos = articleInfoOper.findByParams(articleInfo);

    for (ArticleInfo articleInfo2 : articleInfos) {
      System.out.println(articleInfo2.getArticleId());
    }

    assertTrue(articleInfos != null);
  }
}
