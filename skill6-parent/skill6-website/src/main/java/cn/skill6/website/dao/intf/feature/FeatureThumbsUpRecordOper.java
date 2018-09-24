package cn.skill6.website.dao.intf.feature;

import java.util.List;

import cn.skill6.common.entity.po.feature.FeatureThumbsUpRecord;

/**
 * 点赞操作接口
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月24日 上午12:29:55
 */
public interface FeatureThumbsUpRecordOper {
  int deleteByPrimaryKey(Long userId, Long articleId, String thumbsUpType);

  int addThumbsUpRecord(FeatureThumbsUpRecord featureThumbsUpRecord);

  FeatureThumbsUpRecord findByPrimaryKey(Long userId, Long articleId, String thumbsUpType);

  List<FeatureThumbsUpRecord> findAll();

  int modifyByPrimaryKey(FeatureThumbsUpRecord featureThumbsUpRecord);
}
