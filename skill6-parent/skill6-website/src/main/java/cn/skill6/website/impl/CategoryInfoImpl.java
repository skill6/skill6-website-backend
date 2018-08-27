package cn.skill6.website.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.CategoryInfo;
import cn.skill6.service.intf.basic.CategoryInfoOper;
import cn.skill6.website.dao.CategoryInfoMapper;

/**
 * 目录信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:17:33
 */
public class CategoryInfoImpl implements CategoryInfoOper {
  private static final Logger logger = LoggerFactory.getLogger(CategoryInfoImpl.class);

  @Autowired private CategoryInfoMapper categoryInfoMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.CategoryInfoOper#deleteByCategoryId(java.lang.Long)
   */
  @Override
  public int deleteByCategoryId(Long categoryId) {
    logger.warn("删除id为{}的目录", categoryId);

    return categoryInfoMapper.deleteByPrimaryKey(categoryId);
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
