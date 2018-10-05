package cn.skill6.website.dao.impl.feature;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.feature.FeatureDiscussArea;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.feature.FeatureDiscussAreaDao;
import cn.skill6.website.dao.mappers.feature.FeatureDiscussAreaMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 讨论区操作实现类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月28日 上午12:17:53
 */
public class FeatureDiscussAreaDaoOper implements FeatureDiscussAreaDao {
  private static final Logger logger = LoggerFactory.getLogger(FeatureDiscussAreaDaoOper.class);

  @Autowired private FeatureDiscussAreaMapper featureDiscussAreaMapper;

  @Override
  public int deleteByDiscussId(Long discussId) {
    logger.warn("删除id为{}的讨论区", discussId);

    return featureDiscussAreaMapper.deleteByPrimaryKey(discussId);
  }

  @Override
  public Long addDiscussArea(FeatureDiscussArea featureDiscussArea) {
    if (featureDiscussArea.getDiscussBelongId() == null) {
      throw new NullPointerException("讨论所属主题id不能为null");
    }
    if (featureDiscussArea.getDiscussParentId() == null) {
      throw new NullPointerException("讨论所属父主题不能为null");
    }
    if (featureDiscussArea.getDiscussComitterId() == null) {
      throw new NullPointerException("提交者id不能为空");
    }

    Long discussId = featureDiscussArea.getDiscussId();
    if (discussId == null) {
      discussId = SequenceManager.getNextId();
    }
    featureDiscussArea.setDiscussId(discussId);

    featureDiscussArea.setDiscussCreateTime(new Date());
    featureDiscussArea.setDiscussValid(true);

    featureDiscussAreaMapper.insert(featureDiscussArea);
    logger.info("增加讨论成功,{}", featureDiscussArea);

    return discussId;
  }

  @Override
  public FeatureDiscussArea findByDiscussId(Long discussId) {
    if (discussId == null) {
      throw new NullPointerException("讨论id不能为null");
    }

    FeatureDiscussArea featureDiscussArea = featureDiscussAreaMapper.selectByPrimaryKey(discussId);
    logger.info("找到id为{}的讨论,{}", discussId, featureDiscussArea);

    return featureDiscussArea;
  }

  @Override
  public List<FeatureDiscussArea> findAll() {
    List<FeatureDiscussArea> featureDiscussAreas = featureDiscussAreaMapper.selectAll();
    logger.info("找到所有讨论,{}", featureDiscussAreas);

    return featureDiscussAreas;
  }

  @Override
  public void modifyByDiscussId(FeatureDiscussArea featureDiscussArea) {
    if (featureDiscussArea == null || featureDiscussArea.getDiscussId() == null) {
      throw new NullPointerException("讨论或者讨论id不能为null");
    }

    featureDiscussAreaMapper.updateByPrimaryKey(featureDiscussArea);
    logger.info(
        "成功修改id为{}的讨论为{}",
        featureDiscussArea.getDiscussId(),
        featureDiscussArea.getDiscussContent());
  }
}
