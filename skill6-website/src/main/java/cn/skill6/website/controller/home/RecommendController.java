package cn.skill6.website.controller.home;

import cn.skill6.common.entity.vo.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页推荐
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 22:47
 */
@Slf4j
@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @GetMapping(value = "/carousel")
    public ResponseJson getCarousel() {
        return null;
    }

    @GetMapping(value = "/video")
    public ResponseJson getVideo() {
        return null;
    }

    @GetMapping(value = "/download")
    public ResponseJson getDownload() {
        return null;
    }

    @GetMapping(value = "/question")
    public ResponseJson getQuestion() {
        return null;
    }

    @GetMapping(value = "/article")
    public ResponseJson getArticle() {
        return null;
    }

}
