package cn.skill6.website.controller.article;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.article.ArticleSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制器
 *
 * @author 何明胜
 * @since 2018年8月16日 下午11:05:32
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleSvc articleSvc;

    @PostMapping
    public ResponseJson addArticle(ArticleInfo articleInfo) {
        return articleSvc.addArticle(articleInfo);
    }

    @DeleteMapping("/{articleId}")
    public ResponseJson deleteArticleById(@PathVariable("articleId") long articleId) {
        return articleSvc.deleteArticleById(articleId);
    }

    @PutMapping
    public ResponseJson modifyArticleById(ArticleInfo articleInfo) {
        return articleSvc.modifyArticleById(articleInfo);
    }

    @GetMapping("/{articleId}")
    public ResponseJson getArticleById(@PathVariable("articleId") long articleId) {
        return articleSvc.getArticleById(articleId);
    }

    @GetMapping
    public ResponseJson getArticlesByPage(int pageSize, int pageNum) {
        return articleSvc.getAllArticles();
    }
}
