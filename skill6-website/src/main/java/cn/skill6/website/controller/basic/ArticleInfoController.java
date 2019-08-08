package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.microservice.basic.article.ArticleInfoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 文章信息控制器
 *
 * @author 何明胜
 * @version 1.6
 * @since 2018年8月16日 下午11:05:32
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleInfoController {

    @Autowired
    private ArticleInfoSvc articleInfoSvc;

    @PostMapping
    public ResponseJson addArticle(ArticleInfo articleInfo) {
        return articleInfoSvc.addArticle(articleInfo);
    }

    @DeleteMapping(value = "/{articleId}")
    public ResponseJson deleteArticleById(@PathVariable(name = "articleId") Long articleId) {
        return articleInfoSvc.deleteArticleById(articleId);
    }

    @PutMapping
    public ResponseJson modifyArticleById(ArticleInfo articleInfo) {
        return articleInfoSvc.modifyArticleById(articleInfo);
    }

    @GetMapping(value = "/{articleId}")
    public ResponseJson getArticleById(@PathVariable(name = "articleId") Long articleId) {
        return articleInfoSvc.getArticleById(articleId);
    }

    @GetMapping(value = "/all")
    public String getAllArticles() throws IOException {
        return articleInfoSvc.getAllArticles();
    }
}
