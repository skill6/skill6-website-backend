package cn.skill6.website.dao.mappers.feature;

import cn.skill6.common.entity.po.feature.FeatureCategoryInfo;

import java.util.List;

/**
 * 目录分类信息mapper
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:39:53
 */
public interface FeatureCategoryInfoMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(FeatureCategoryInfo featureCategoryInfo);

    FeatureCategoryInfo selectByPrimaryKey(Long categoryId);

    List<FeatureCategoryInfo> selectAll();

    int updateByPrimaryKey(FeatureCategoryInfo featureCategoryInfo);
}
