package cn.skill6.website.service.article;

import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.article.CommentSvc;
import cn.skill6.website.dao.intf.article.ArticleCommentDao;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 评论服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 00:36
 */
@Slf4j
@Service
@Component
public class CommentService implements CommentSvc {

    @Autowired
    private ArticleCommentDao articleCommentDao;

    @Override
    public ResponseJson getCommentsByPage(int pageSize, int pageNum) {
        PageResult<ArticleComment> commentPageResult = articleCommentDao.findCommentsByPage(pageSize, pageNum);
        return new ResponseJson(commentPageResult);
    }

    @Override
    public ResponseJson getCommentById(long commentId) {
        ArticleComment articleComment = articleCommentDao.findByCommentId(commentId);
        return new ResponseJson(articleComment);
    }
}
