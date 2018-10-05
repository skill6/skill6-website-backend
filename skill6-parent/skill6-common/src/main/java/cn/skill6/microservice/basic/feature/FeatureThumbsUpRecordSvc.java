package cn.skill6.microservice.basic.feature;

import cn.skill6.common.entity.po.feature.FeatureThumbsUpRecord;
import cn.skill6.common.entity.vo.ResponseJson;

/**
 * 点赞记录微服务接口
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年10月5日 下午8:06:52
 */
public interface FeatureThumbsUpRecordSvc {
  public ResponseJson addThumbsUpRecord(FeatureThumbsUpRecord featureThumbsUpRecord);

  public ResponseJson findByPrimaryKey(Long userId, Long articleId, String thumbsUpType);

  public ResponseJson findAll();

  public ResponseJson modifyByPrimaryKey(FeatureThumbsUpRecord featureThumbsUpRecord);
}
