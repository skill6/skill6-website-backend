package cn.skill6.website.service.basic.feature;

import cn.skill6.common.entity.enums.CategoryType;
import cn.skill6.common.entity.po.other.CategoryInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.exception.general.FormatException;
import cn.skill6.microservice.basic.CategoryInfoSvc;
import cn.skill6.website.dao.intf.other.CategoryInfoDao;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 目录信息处理服务类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月5日 下午4:21:03
 */
@Service
@Component
public class CategoryInfoService implements CategoryInfoSvc {

    @Autowired
    private CategoryInfoDao categoryInfoDao;

    @Override
    public ResponseJson addCategoryInfo(CategoryInfo categoryInfo) {
        ResponseJson responseJson;

        try {
            Long categoryId = categoryInfoDao.addCategoryInfo(categoryInfo);
            responseJson = new ResponseJson(true, String.valueOf(categoryId));
        } catch (Exception e) {
            responseJson = new ResponseJson(false, "注册失败");
        }

        return responseJson;
    }

    @Override
    public ResponseJson addCategoryInfo(CategoryInfo categoryInfo, int categoryType) {
        switch (categoryType) {
            case 100:
                categoryInfo.setCategoryType(CategoryType.ARTICLE);
                break;
            case 200:
                categoryInfo.setCategoryType(CategoryType.DISCUSS_AREA);
                break;
            case 300:
                categoryInfo.setCategoryType(CategoryType.FILE_DOWNLOAD);
                break;

            default:
                throw new FormatException("目录格式错误");
        }

        return addCategoryInfo(categoryInfo);
    }
}
