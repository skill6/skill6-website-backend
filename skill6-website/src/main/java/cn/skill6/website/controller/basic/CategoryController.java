package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.po.other.CategoryInfo;
import cn.skill6.website.basic.CategorySvc;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategorySvc categorySvc;

    @PostMapping("/{categoryType}")
    public Long addCategoryInfo(CategoryInfo categoryInfo, @PathVariable("categoryType") String categoryType) {
        return categorySvc.addCategory(categoryInfo, categoryType);
    }
}
