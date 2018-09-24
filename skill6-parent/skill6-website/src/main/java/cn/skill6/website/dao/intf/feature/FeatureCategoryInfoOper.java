package cn.skill6.website.dao.intf.feature;

import java.util.List;

import cn.skill6.common.entity.po.feature.FeatureCategoryInfo;

/**
 * 目录信息操作接口
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月24日 上午12:28:03
 */
public interface FeatureCategoryInfoOper {
  int deleteByCategoryId(Long categoryId);

  Long addCategoryInfo(FeatureCategoryInfo featureCategoryInfo);

  FeatureCategoryInfo findByCategoryId(Long categoryId);

  List<FeatureCategoryInfo> findAll();

  void modifyByCategoryId(FeatureCategoryInfo featureCategoryInfo);
}
