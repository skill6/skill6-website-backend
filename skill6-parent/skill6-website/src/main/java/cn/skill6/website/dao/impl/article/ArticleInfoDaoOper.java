package cn.skill6.website.dao.impl.article;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.website.dao.intf.article.ArticleInfoDao;
import cn.skill6.website.dao.mappers.article.ArticleInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 文章信息操作实现类
 *
 * @author 何明胜
 * @version 1.6
 * @since 2018年8月16日 下午10:29:29
 */
@Repository
public class ArticleInfoDaoOper implements ArticleInfoDao {

  private static final Logger logger = LoggerFactory.getLogger(ArticleInfoDaoOper.class);

  @Autowired private ArticleInfoMapper articleInfoMapper;

  @Override
  public int deleteByPrimaryKey(Long articleId) {
    logger.warn("删除id为{}的用户", articleId);
    return articleInfoMapper.deleteByPrimaryKey(articleId);
  }

  @Override
  public Long addArticleInfo(ArticleInfo articleInfo) {
    // 设置分布式用户id
    Long articleId = articleInfo.getArticleId();
    if (articleId == null) {
      articleId = SequenceManager.getNextId();
    }
    articleInfo.setArticleId(articleId);

    // 设置创建日期和最后修改日期
    articleInfo.setArticleCreateTime(new Date());
    articleInfo.setArticleLastModifyTime(new Date());
    // 默认不置顶、无附件
    articleInfo.setArtilcePlaceTop(false);
    articleInfo.setArticleAttachFile(false);
    // 初始化阅读为0
    articleInfo.setArticleReadTotal(0);
    // 默认文章有效
    articleInfo.setArticleValid(true);

    // 增加其他字段的校验
    articleInfoMapper.insert(articleInfo);

    logger.info("增加文章成功,{}", articleInfo);

    return articleId;
  }

  @Override
  public ArticleInfo findByArticleId(Long articleId) {
    ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(articleId);

    logger.info("找到id为{}的文章,{}", articleId, articleInfo);

    return articleInfo;
  }

  @Override
  public List<ArticleInfo> findAll() {
    List<ArticleInfo> articleInfos = articleInfoMapper.selectAll();

    logger.info("找到所有文章, {}", articleInfos);

    return articleInfos;
  }

  @Override
  public void modifyByArticleId(ArticleInfo articleInfo) {
    // TODO 增加修改的校验和继续完善
    ArticleInfo articleInfoNew = findByArticleId(articleInfo.getArticleId());

    if (BaseUtils.isNotEmpty(articleInfo.getArticleTitle())) {
      articleInfoNew.setArticleTitle(articleInfo.getArticleTitle());
    }
    if (BaseUtils.isNotEmpty(articleInfo.getArticleHtmlContent())) {
      articleInfoNew.setArticleHtmlContent(articleInfo.getArticleHtmlContent());
    }

    articleInfoMapper.updateByPrimaryKey(articleInfoNew);

    logger.info("成功修改id为{}的文章内容", articleInfo.getArticleId());
  }

  @Override
  public List<ArticleInfo> findByParams(ArticleInfo articleInfo) {
    // 设置分页数据
    Page<ArticleInfo> page =
        PageHelper.startPage(articleInfo.getPageNum(), articleInfo.getPageSize());

    List<ArticleInfo> articleInfos = articleInfoMapper.selectByParams(articleInfo);

    logger.info("找到文章数量：{}, 所有文章数量为：{}", articleInfos.size(), page.getTotal());

    return articleInfos;
  }
}
