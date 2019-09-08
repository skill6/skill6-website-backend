package cn.skill6.website.controller.article;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.article.CommentSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章评论
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 23:01
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentSvc commentSvc;

    @GetMapping
    public ResponseJson getCommentsByPage(int pageSize, int pageNum) {
        return commentSvc.getCommentsByPage(pageSize, pageNum);
    }

    @GetMapping("/{commentId}")
    public ResponseJson getCommentById(@PathVariable("commentId") long commentId) {
        return commentSvc.getCommentById(commentId);
    }

}
