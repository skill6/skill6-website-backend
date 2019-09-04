package cn.skill6.website.dao.mappers.other;

import cn.skill6.common.entity.po.other.CategoryInfo;

import java.util.List;

/**
 * 目录分类信息mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:39:53
 */
public interface CategoryInfoMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(CategoryInfo featureCategoryInfo);

    CategoryInfo selectByPrimaryKey(Long categoryId);

    List<CategoryInfo> selectAll();

    int updateByPrimaryKey(CategoryInfo featureCategoryInfo);
}
