package cn.skill6.website.service.article;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.article.CommentSvc;

/**
 * 评论服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 00:36
 */
public class CommentService implements CommentSvc {

    @Override
    public ResponseJson getCommentsByPage(int pageSize, int pageNum) {
        return null;
    }

    @Override
    public ResponseJson getCommentById(long commentId) {
        return null;
    }
}
