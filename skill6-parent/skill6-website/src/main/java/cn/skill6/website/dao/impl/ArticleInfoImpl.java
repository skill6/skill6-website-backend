package cn.skill6.website.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.entity.po.ArticleInfo;
import cn.skill6.website.dao.ArticleInfoMapper;
import cn.skill6.website.dao.intf.ArticleInfoOper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 文章信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月16日 下午10:29:29
 */
@Repository
public class ArticleInfoImpl implements ArticleInfoOper {

  private static final Logger logger = LoggerFactory.getLogger(ArticleInfoImpl.class);

  @Autowired private ArticleInfoMapper articleInfoMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.ArticleInfo#deleteByPrimaryKey(java.lang.Long)
   */
  @Override
  public int deleteByPrimaryKey(Long articleId) {
    logger.warn("删除id为{}的用户", articleId);
    return articleInfoMapper.deleteByPrimaryKey(articleId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.ArticleInfo#addArticleInfo(cn.skill6.service.intf.ArticleInfo)
   */
  @Override
  public Long addArticleInfo(ArticleInfo articleInfo) {
    // 设置分布式用户id
    Long articleId = articleInfo.getArticleId();
    if (articleId == null) {
    	articleId = SequenceManager.getNextId();
    }
    articleInfo.setArticleId(articleId);

    // 设置创建日期和最后修改日期
    articleInfo.setArticleCreateDate(new Date());
    articleInfo.setArticleLastModifyDate(new Date());
    // 默认不置顶、无附件
    articleInfo.setArtilcePlaceTop(false);
    articleInfo.setArticleAttachFile(false);
    // 初始化阅读为0
    articleInfo.setArticleReadTotal(0);
    // 默认文章有效
    articleInfo.setArticleValid(true);

    // TODO 增加其他字段的校验
    articleInfoMapper.insert(articleInfo);

    logger.info("增加文章成功,{}", articleInfo);

    return articleId;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.ArticleInfo#findByPrimaryKey(java.lang.Long)
   */
  @Override
  public ArticleInfo findByArticleId(Long articleId) {
    ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(articleId);

    logger.info("找到id为{}的文章,{}", articleId, articleInfo);

    return articleInfo;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.ArticleInfo#findAll()
   */
  @Override
  public List<ArticleInfo> findAll() {
    List<ArticleInfo> articleInfos = articleInfoMapper.selectAll();

    logger.info("找到所有文章, {}", articleInfos);

    return articleInfos;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.ArticleInfo#modifyByPrimaryKey(cn.skill6.service.intf.ArticleInfo)
   */
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
}
