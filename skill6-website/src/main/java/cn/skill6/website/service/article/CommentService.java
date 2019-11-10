package cn.skill6.website.service.article;

import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.entity.po.article.ArticleCommentReply;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.article.CommentSvc;
import cn.skill6.website.dao.intf.article.ArticleCommentDao;
import cn.skill6.website.dao.intf.article.ArticleCommentReplyDao;
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

    @Autowired
    private ArticleCommentReplyDao articleCommentReplyDao;

    @Override
    public PageResult<ArticleComment> getCommentsByPage(int pageSize, int pageNum) {
        return articleCommentDao.findCommentsByPage(pageSize, pageNum);
    }

    @Override
    public ArticleComment getCommentById(long commentId) {
        return articleCommentDao.findByCommentId(commentId);
    }

    @Override
    public long addArticleComment(ArticleComment articleComment) {
        return articleCommentDao.addArticleComment(articleComment);
    }

    @Override
    public long addArticleCommentReply(ArticleCommentReply articleCommentReply) {
        return articleCommentReplyDao.insert(articleCommentReply);
    }
}
