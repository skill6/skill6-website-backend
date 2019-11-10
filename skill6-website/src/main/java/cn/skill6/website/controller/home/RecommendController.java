package cn.skill6.website.controller.home;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.home.RecommendSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页推荐
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 22:47
 */
@Slf4j
@RestController
@RequestMapping("/api/recommend")
public class RecommendController {

    @Autowired
    private RecommendSvc recommendSvc;

    @GetMapping(value = "/carousel")
    public ResponseJson getCarousel() {
        return recommendSvc.getRecommendCarousel();
    }

    @GetMapping(value = "/video")
    public ResponseJson getVideo() {
        return recommendSvc.getRecommendVideo();
    }

    @GetMapping(value = "/download")
    public ResponseJson getDownload() {
        return recommendSvc.getRecommendDownload();
    }

    @GetMapping(value = "/question")
    public ResponseJson getQuestion() {
        return recommendSvc.getRecommendQuestion();
    }

    @GetMapping(value = "/article")
    public List<ArticleInfo> getArticle() {
        return recommendSvc.getRecommendArticle();
    }

}
