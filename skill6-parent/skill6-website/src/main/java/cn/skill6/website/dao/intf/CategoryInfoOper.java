package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.CategoryInfo;

/**
 * 目录信息操作接口
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月24日 上午12:28:03
 */
public interface CategoryInfoOper {
  int deleteByCategoryId(Long categoryId);

  Long addCategoryInfo(CategoryInfo categoryInfo);

  CategoryInfo findByCategoryId(Long categoryId);

  List<CategoryInfo> findAll();

  void modifyByCategoryId(CategoryInfo categoryInfo);
}
