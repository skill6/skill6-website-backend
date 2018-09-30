package cn.skill6.website.dao.impl.feature;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.feature.FeatureDiscussArea;
import cn.skill6.website.dao.intf.feature.FeatureDiscussAreaDao;
import cn.skill6.website.dao.mappers.feature.FeatureDiscussAreaMapper;

/**
 * 讨论区操作实现类
 *
 * @author 何明胜
 * @version 1.2
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
  public int addDiscussArea(FeatureDiscussArea featureDiscussArea) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public FeatureDiscussArea findByDiscussId(Long discussId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<FeatureDiscussArea> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByDiscussId(FeatureDiscussArea featureDiscussArea) {
    // TODO Auto-generated method stub
    return 0;
  }
}
