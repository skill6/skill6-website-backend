package cn.skill6.website.dao.impl.feature;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.feature.FeatureThumbsUpRecord;
import cn.skill6.website.dao.intf.feature.FeatureThumbsUpRecordOper;
import cn.skill6.website.dao.mappers.feature.FeatureThumbsUpRecordMapper;

/**
 * 点赞记录操作实现类
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月28日 上午12:19:05
 */
public class FeatureThumbsUpRecordImpl implements FeatureThumbsUpRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(FeatureThumbsUpRecordImpl.class);

  @Autowired private FeatureThumbsUpRecordMapper featureThumbsUpRecordMapper;

  @Override
  public int deleteByPrimaryKey(Long userId, Long articleId, String thumbsUpType) {
    logger.warn("删除用户id为{},文章id为{},类型为{}的点赞记录", userId, articleId);

    return featureThumbsUpRecordMapper.deleteByPrimaryKey(userId, articleId, thumbsUpType);
  }

  @Override
  public int addThumbsUpRecord(FeatureThumbsUpRecord featureThumbsUpRecord) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public FeatureThumbsUpRecord findByPrimaryKey(Long userId, Long articleId, String thumbsUpType) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<FeatureThumbsUpRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByPrimaryKey(FeatureThumbsUpRecord featureThumbsUpRecord) {
    // TODO Auto-generated method stub
    return 0;
  }
}
