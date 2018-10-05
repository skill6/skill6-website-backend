package cn.skill6.microservice.basic.feature;

import cn.skill6.common.entity.po.feature.FeatureDiscussArea;
import cn.skill6.common.entity.vo.ResponseJson;

/**
 * 讨论区微服务接口
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年10月5日 下午8:06:35
 */
public interface FeatureDiscussAreaSvc {

  /**
   * 增加讨论
   *
   * @param featureDiscussArea
   * @return
   */
  public ResponseJson addDiscussArea(FeatureDiscussArea featureDiscussArea);

  /**
   * 根据id查找讨论
   *
   * @param discussId
   * @return
   */
  public ResponseJson findByDiscussId(Long discussId);

  /**
   * 查找所有讨论
   *
   * @return
   */
  public ResponseJson findAll();

  /**
   * 修改讨论
   *
   * @param featureDiscussArea
   * @return
   */
  public ResponseJson modifyByDiscussId(FeatureDiscussArea featureDiscussArea);
}
