package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.po.other.CategoryInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.microservice.basic.CategoryInfoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 目录控制器
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月5日 下午3:49:16
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryInfoController {
    @Autowired
    private CategoryInfoSvc categoryInfoSvc;

    @PostMapping("/{categoryType}")
    public ResponseJson addCategoryInfo(CategoryInfo categoryInfo,
                                        @PathVariable(name = "categoryType") int categoryType) {
        return categoryInfoSvc.addCategoryInfo(categoryInfo, categoryType);
    }
}
