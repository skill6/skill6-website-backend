package cn.skill6.website.controller.home;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.website.home.TopNSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * top n 推荐
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 22:52
 */
@Slf4j
@RestController
@RequestMapping("/api/topn")
public class TopNController {

    @Autowired
    private TopNSvc topNSvc;

    @GetMapping("/active-user")
    public List<UserInfo> getActiveUser() {
        return topNSvc.getActiveUsers();
    }

    @GetMapping("/visit-user")
    public List<UserInfo> getVisitUser() {
        return topNSvc.getActiveUsers();
    }

    @GetMapping("/publish-article")
    public List<ArticleInfo> getPublishArticle() {
        return topNSvc.getPublishArticles();
    }

}
