package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.vo.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版本信息
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 22:46
 */
@Slf4j
@RestController
@RequestMapping("/version")
public class VersionController {

    @GetMapping
    public ResponseJson getVersionByPage(int pageSize, int pageNum) {
        return null;
    }

}
