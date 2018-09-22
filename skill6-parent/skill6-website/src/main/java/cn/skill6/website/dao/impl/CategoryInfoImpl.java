package cn.skill6.website.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.entity.enums.CategoryType;
import cn.skill6.common.entity.po.CategoryInfo;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.website.dao.CategoryInfoMapper;
import cn.skill6.website.dao.intf.CategoryInfoOper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 目录信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月28日 上午12:17:33
 */
public class CategoryInfoImpl implements CategoryInfoOper {
  private static final Logger logger = LoggerFactory.getLogger(CategoryInfoImpl.class);

  @Autowired private CategoryInfoMapper categoryInfoMapper;

  @Override
  public int deleteByCategoryId(Long categoryId) {
    logger.warn("删除id为{}的目录", categoryId);

    return categoryInfoMapper.deleteByPrimaryKey(categoryId);
  }

  @Override
  public Long addCategoryInfo(CategoryInfo categoryInfo) {
    Long categoryId = SequenceManager.getNextId();

    if (categoryId == null) {
      throw new NullPointerException();
    }
    categoryInfo.setCategoryId(categoryId);

    // TODO - 后续放在spring mvc中URL判断类型并设置
    categoryInfo.setCategoryType(CategoryType.ARTICLE);

    categoryInfo.setCategoryCreateDate(new Date());
    categoryInfo.setCategoryModifyDate(new Date());
    categoryInfo.setCategoryValid(true);

    categoryInfoMapper.insert(categoryInfo);

    logger.info("增加目录分类成功,{}", categoryInfo);

    return categoryId;
  }

  @Override
  public CategoryInfo findByCategoryId(Long categoryId) {
    CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(categoryId);

    logger.info("找到id为{}的目录，{}", categoryId, categoryInfo);

    return categoryInfo;
  }

  @Override
  public List<CategoryInfo> findAll() {
    List<CategoryInfo> categoryInfos = categoryInfoMapper.selectAll();

    logger.info("找到所有目录,{}", categoryInfos);

    return categoryInfos;
  }

  @Override
  public void modifyByCategoryId(CategoryInfo categoryInfo) {
    if (categoryInfo == null || categoryInfo.getCategoryId() == null) {
      throw new NullPointerException("目录或者目录id不能为空");
    }
    CategoryInfo categoryInfoNew =
        categoryInfoMapper.selectByPrimaryKey(categoryInfo.getCategoryId());

    if (BaseUtils.isNotEmpty(categoryInfo.getCategoryName())) {
      categoryInfoNew.setCategoryName(categoryInfo.getCategoryName());
    }
    categoryInfoNew.setCategoryModifyDate(new Date());

    categoryInfoMapper.updateByPrimaryKey(categoryInfoNew);

    logger.info("成功修改id为{}的目录内容", categoryInfo.getCategoryId());
  }
}
