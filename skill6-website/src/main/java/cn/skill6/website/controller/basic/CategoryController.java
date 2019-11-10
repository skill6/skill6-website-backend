package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.po.other.CategoryInfo;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.basic.CategorySvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 目录控制器
 *
 * @author 何明胜
 * @since 2018年10月5日 下午3:49:16
 */
@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategorySvc categorySvc;

    @PostMapping
    public long addCategoryInfo(@RequestBody CategoryInfo categoryInfo) {
        log.info("categoryInfo: {}", JacksonUtil.toStr(categoryInfo));

        return categorySvc.addCategory(categoryInfo);
    }
}
