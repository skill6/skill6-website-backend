package cn.skill6.website.dao.intf.basic;

import cn.skill6.common.entity.po.other.CategoryInfo;

import java.util.List;

/**
 * 目录信息操作接口
 *
 * @author 何明胜
 * @since 2018年8月24日 上午12:28:03
 */
public interface CategoryDao {
    int deleteByCategoryId(Long categoryId);

    long addCategoryInfo(CategoryInfo featureCategoryInfo);

    CategoryInfo findByCategoryId(Long categoryId);

    List<CategoryInfo> findAll();

    void modifyByCategoryId(CategoryInfo featureCategoryInfo);
}
