package cn.skill6.website.controller.home;

import cn.skill6.common.entity.vo.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问统计
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 22:57
 */
@Slf4j
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @GetMapping("/visit")
    public ResponseJson getVisit() {
        return null;
    }

    @GetMapping("/online")
    public ResponseJson getOnline() {
        return null;
    }
}
