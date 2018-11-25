package cn.skill6.website.dao.impl.feature;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.entity.po.feature.FeatureCategoryInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.feature.FeatureCategoryInfoDao;
import cn.skill6.website.dao.mappers.feature.FeatureCategoryInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;

/**
 * 目录信息操作实现类
 *
 * @author 何明胜
 * @version 1.6
 * @since 2018年8月28日 上午12:17:33
 */
@Slf4j
@Repository
public class FeatureCategoryInfoDaoOper implements FeatureCategoryInfoDao {

  @Autowired private FeatureCategoryInfoMapper featureCategoryInfoMapper;

  @Override
  public int deleteByCategoryId(Long categoryId) {
    log.warn("删除id为{}的目录", categoryId);

    return featureCategoryInfoMapper.deleteByPrimaryKey(categoryId);
  }

  @Override
  public Long addCategoryInfo(FeatureCategoryInfo featureCategoryInfo) {
    Long categoryId = SequenceManager.getNextId();
    featureCategoryInfo.setCategoryId(categoryId);

    featureCategoryInfo.setCategoryCreateTime(new Date());
    featureCategoryInfo.setCategoryUpdateTime(new Date());
    featureCategoryInfo.setCategoryValid(true);

    featureCategoryInfoMapper.insert(featureCategoryInfo);
    log.info("增加目录分类成功,{}", featureCategoryInfo);

    return categoryId;
  }

  @Override
  public FeatureCategoryInfo findByCategoryId(Long categoryId) {
    FeatureCategoryInfo categoryInfo = featureCategoryInfoMapper.selectByPrimaryKey(categoryId);
    log.info("找到id为{}的目录,{}", categoryId, categoryInfo);

    return categoryInfo;
  }

  @Override
  public List<FeatureCategoryInfo> findAll() {
    List<FeatureCategoryInfo> categoryInfos = featureCategoryInfoMapper.selectAll();
    log.info("找到所有目录,{}", categoryInfos);

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
    categoryInfoNew.setCategoryUpdateTime(new Date());

    featureCategoryInfoMapper.updateByPrimaryKey(categoryInfoNew);
    log.info("成功修改id为{}的目录内容", featureCategoryInfo.getCategoryId());
  }
}
