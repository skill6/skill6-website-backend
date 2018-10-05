package cn.skill6.microservice.basic.feature;

import cn.skill6.common.entity.po.feature.FeatureCategoryInfo;
import cn.skill6.common.entity.vo.ResponseJson;

/**
 * 信息目录服务接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月5日 下午4:10:03
 */
public interface FeatureCategoryInfoSvc {
  /**
   * 增加目录信息
   *
   * @param featureCategoryInfo
   * @param categoryType
   * @return 操作结果
   */
  public ResponseJson addCategoryInfo(FeatureCategoryInfo featureCategoryInfo, int categoryType);

  /**
   * 增加目录信息
   *
   * @param featureCategoryInfo
   * @return
   */
  ResponseJson addCategoryInfo(FeatureCategoryInfo featureCategoryInfo);
}
