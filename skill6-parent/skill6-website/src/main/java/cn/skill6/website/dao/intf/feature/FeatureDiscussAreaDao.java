package cn.skill6.website.dao.intf.feature;

import java.util.List;

import cn.skill6.common.entity.po.feature.FeatureDiscussArea;

/**
 * 讨论区操作接口
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月24日 上午12:28:17
 */
public interface FeatureDiscussAreaDao {
  int deleteByDiscussId(Long discussId);

  int addDiscussArea(FeatureDiscussArea featureDiscussArea);

  FeatureDiscussArea findByDiscussId(Long discussId);

  List<FeatureDiscussArea> findAll();

  int modifyByDiscussId(FeatureDiscussArea featureDiscussArea);
}
