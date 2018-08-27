package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.CategoryInfo;
import cn.skill6.service.intf.basic.CategoryInfoOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:17:33
 */
public class CategoryInfoImpl implements CategoryInfoOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.CategoryInfoOper#deleteByCategoryId(java.lang.Long)
   */
  @Override
  public int deleteByCategoryId(Long categoryId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.CategoryInfoOper#addCategoryInfo(cn.skill6.common.entity.po.CategoryInfo)
   */
  @Override
  public int addCategoryInfo(CategoryInfo categoryInfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.CategoryInfoOper#selectByCategoryId(java.lang.Long)
   */
  @Override
  public CategoryInfo selectByCategoryId(Long categoryId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.CategoryInfoOper#findAll()
   */
  @Override
  public List<CategoryInfo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.CategoryInfoOper#modifyByCategoryId(cn.skill6.common.entity.po.CategoryInfo)
   */
  @Override
  public int modifyByCategoryId(CategoryInfo categoryInfo) {
    // TODO Auto-generated method stub
    return 0;
  }
}
