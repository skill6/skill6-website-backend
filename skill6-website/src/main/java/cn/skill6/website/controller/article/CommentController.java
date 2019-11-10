package cn.skill6.website.controller.article;

import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.entity.po.article.ArticleCommentReply;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.article.CommentSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章评论
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 23:01
 */
@Slf4j
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentSvc commentSvc;

    @GetMapping
    public PageResult<ArticleComment> getCommentsByPage(int pageSize, int pageNum) {
        return commentSvc.getCommentsByPage(pageSize, pageNum);
    }

    @GetMapping("/{commentId}")
    public ArticleComment getCommentById(@PathVariable("commentId") long commentId) {
        return commentSvc.getCommentById(commentId);
    }

    @PostMapping
    public long addArticleComment(@RequestBody ArticleComment articleComment) {
        log.info("addArticleComment: {}", JacksonUtil.toStr(articleComment));
        return commentSvc.addArticleComment(articleComment);
    }

    @PostMapping("/reply")
    public long addArticleCommentReply(@RequestBody ArticleCommentReply articleCommentReply) {
        log.info("addArticleCommentReply: {}", JacksonUtil.toStr(articleCommentReply));
        return commentSvc.addArticleCommentReply(articleCommentReply);
    }
}
