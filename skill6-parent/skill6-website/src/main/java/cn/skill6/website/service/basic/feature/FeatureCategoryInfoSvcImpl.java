package cn.skill6.website.service.basic.feature;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.skill6.common.entity.enums.CategoryType;
import cn.skill6.common.entity.po.feature.FeatureCategoryInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.exception.general.FormatException;
import cn.skill6.microservice.basic.feature.FeatureCategoryInfoSvc;
import cn.skill6.website.dao.intf.feature.FeatureCategoryInfoDao;

/**
 * 目录信息处理服务类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月5日 下午4:21:03
 */
@Service
@Component
public class FeatureCategoryInfoSvcImpl implements FeatureCategoryInfoSvc {

  @Resource(name = "featureCategoryInfoDaoOper")
  private FeatureCategoryInfoDao featureCategoryInfoDao;

  @Override
  public ResponseJson addCategoryInfo(FeatureCategoryInfo featureCategoryInfo) {
    ResponseJson responseJson;

    try {
      Long categoryId = featureCategoryInfoDao.addCategoryInfo(featureCategoryInfo);
      responseJson = new ResponseJson(true, String.valueOf(categoryId));
    } catch (Exception e) {
      responseJson = new ResponseJson(false, "注册失败");
    }

    return responseJson;
  }

  @Override
  public ResponseJson addCategoryInfo(FeatureCategoryInfo featureCategoryInfo, int categoryType) {
    switch (categoryType) {
      case 100:
        featureCategoryInfo.setCategoryType(CategoryType.ARTICLE);
        break;
      case 200:
        featureCategoryInfo.setCategoryType(CategoryType.DISCUSS_AREA);
        break;
      case 300:
        featureCategoryInfo.setCategoryType(CategoryType.FILE_DOWNLOAD);
        break;

      default:
        throw new FormatException("目录格式错误");
    }

    return addCategoryInfo(featureCategoryInfo);
  }
}
