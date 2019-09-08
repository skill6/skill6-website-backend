package cn.skill6.website.service.basic;

import cn.skill6.common.entity.enums.CategoryType;
import cn.skill6.common.entity.po.other.CategoryInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.basic.CategorySvc;
import cn.skill6.website.dao.intf.basic.CategoryDao;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 目录信息处理服务类
 *
 * @author 何明胜
 * @since 2018年10月5日 下午4:21:03
 */
@Service
@Component
public class CategoryService implements CategorySvc {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public ResponseJson addCategory(CategoryInfo categoryInfo) {
        Long categoryId = categoryDao.addCategoryInfo(categoryInfo);

        return new ResponseJson(categoryId);
    }

    @Override
    public ResponseJson addCategory(CategoryInfo categoryInfo, String categoryType) {
        categoryInfo.setCategoryType(CategoryType.getEnum(categoryType));

        return addCategory(categoryInfo);
    }
}
