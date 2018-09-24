package cn.skill6.website.dao.mappers.feature;

import cn.skill6.common.entity.po.feature.FeatureThumbsUpRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 点赞记录mapper
 *
 * @author 何明胜
 * @version 1.0.4
 * @since 2018年8月15日 下午11:41:09
 */
public interface FeatureThumbsUpRecordMapper {
  int deleteByPrimaryKey(
      @Param("userId") Long userId,
      @Param("articleId") Long articleId,
      @Param("thumbsUpType") String thumbsUpType);

  int insert(FeatureThumbsUpRecord featureThumbsUpRecord);

  FeatureThumbsUpRecord selectByPrimaryKey(
      @Param("userId") Long userId,
      @Param("articleId") String articleId,
      @Param("thumbsUpType") String thumbsUpType);

  List<FeatureThumbsUpRecord> selectAll();

  int updateByPrimaryKey(FeatureThumbsUpRecord featureThumbsUpRecord);
}
