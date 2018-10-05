package cn.skill6.website.dao.impl.feature;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.entity.po.feature.FeatureCategoryInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.feature.FeatureCategoryInfoDao;
import cn.skill6.website.dao.mappers.feature.FeatureCategoryInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 目录信息操作实现类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月28日 上午12:17:33
 */
@Repository
public class FeatureCategoryInfoDaoOper implements FeatureCategoryInfoDao {
  private static final Logger logger = LoggerFactory.getLogger(FeatureCategoryInfoDaoOper.class);

  @Autowired private FeatureCategoryInfoMapper featureCategoryInfoMapper;

  @Override
  public int deleteByCategoryId(Long categoryId) {
    logger.warn("删除id为{}的目录", categoryId);

    return featureCategoryInfoMapper.deleteByPrimaryKey(categoryId);
  }

  @Override
  public Long addCategoryInfo(FeatureCategoryInfo featureCategoryInfo) {
    Long categoryId = SequenceManager.getNextId();

    if (categoryId == null) {
      throw new NullPointerException();
    }
    featureCategoryInfo.setCategoryId(categoryId);

    featureCategoryInfo.setCategoryCreateTime(new Date());
    featureCategoryInfo.setCategoryModifyTime(new Date());
    featureCategoryInfo.setCategoryValid(true);

    featureCategoryInfoMapper.insert(featureCategoryInfo);

    logger.info("增加目录分类成功,{}", featureCategoryInfo);

    return categoryId;
  }

  @Override
  public FeatureCategoryInfo findByCategoryId(Long categoryId) {
    FeatureCategoryInfo categoryInfo = featureCategoryInfoMapper.selectByPrimaryKey(categoryId);

    logger.info("找到id为{}的目录，{}", categoryId, categoryInfo);

    return categoryInfo;
  }

  @Override
  public List<FeatureCategoryInfo> findAll() {
    List<FeatureCategoryInfo> categoryInfos = featureCategoryInfoMapper.selectAll();

    logger.info("找到所有目录,{}", categoryInfos);

    return categoryInfos;
  }

  @Override
  public void modifyByCategoryId(FeatureCategoryInfo featureCategoryInfo) {
    if (featureCategoryInfo == null || featureCategoryInfo.getCategoryId() == null) {
      throw new NullPointerException("目录或者目录id不能为空");
    }
    FeatureCategoryInfo categoryInfoNew =
        featureCategoryInfoMapper.selectByPrimaryKey(featureCategoryInfo.getCategoryId());

    if (BaseUtils.isNotEmpty(featureCategoryInfo.getCategoryName())) {
      categoryInfoNew.setCategoryName(featureCategoryInfo.getCategoryName());
    }
    categoryInfoNew.setCategoryModifyTime(new Date());

    featureCategoryInfoMapper.updateByPrimaryKey(categoryInfoNew);

    logger.info("成功修改id为{}的目录内容", featureCategoryInfo.getCategoryId());
  }
}
