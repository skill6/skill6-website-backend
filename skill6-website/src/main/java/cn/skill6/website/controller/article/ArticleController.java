package cn.skill6.website.controller.article;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.entity.vo.article.ArticleCommentVo;
import cn.skill6.common.entity.vo.article.ArticleInfoVo;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.article.ArticleSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制器
 *
 * @author 何明胜
 * @since 2018年8月16日 下午11:05:32
 */
@Slf4j
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleSvc articleSvc;

    @PostMapping
    public long addArticle(@RequestBody ArticleInfo articleInfo) {
        return articleSvc.addArticle(articleInfo);
    }

    @DeleteMapping("/{articleId}")
    public int deleteArticleById(@PathVariable("articleId") long articleId) {
        return articleSvc.deleteArticleById(articleId);
    }

    @PutMapping
    public ResponseJson modifyArticleById(@RequestBody ArticleInfo articleInfo) {
        log.info("modifyArticleById: {}", JacksonUtil.toStr(articleInfo));

        return articleSvc.modifyArticleById(articleInfo);
    }

    @GetMapping("/{articleId}")
    public ArticleInfo getArticleById(@PathVariable("articleId") long articleId) {
        return articleSvc.getArticleById(articleId);
    }

    @GetMapping
    public PageResult<ArticleInfoVo> getArticlesByPage(int pageSize, int pageNum) {
        return articleSvc.getArticlesByPage(pageSize, pageNum);
    }

    @GetMapping("/{articleId}/comments")
    public PageResult<ArticleCommentVo> getCommentsByArticleIdWithPage(@PathVariable("articleId") long articleId,
                                                                       int pageSize, int pageNum) {
        return articleSvc.getCommentsByArticleIdWithPage(articleId, pageSize, pageNum);
    }
}
