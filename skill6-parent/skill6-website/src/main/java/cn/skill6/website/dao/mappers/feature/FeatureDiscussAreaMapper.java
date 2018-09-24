package cn.skill6.website.dao.mappers.feature;

import cn.skill6.common.entity.po.feature.FeatureDiscussArea;
import java.util.List;

/**
 * 讨论区mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:40:09
 */
public interface FeatureDiscussAreaMapper {
  int deleteByPrimaryKey(Long discussId);

  int insert(FeatureDiscussArea featureDiscussArea);

  FeatureDiscussArea selectByPrimaryKey(Long discussId);

  List<FeatureDiscussArea> selectAll();

  int updateByPrimaryKey(FeatureDiscussArea featureDiscussArea);
}
