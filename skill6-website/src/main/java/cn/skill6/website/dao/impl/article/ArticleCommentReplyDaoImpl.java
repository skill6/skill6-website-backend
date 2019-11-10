package cn.skill6.website.dao.impl.article;

import cn.skill6.common.entity.po.article.ArticleCommentReply;
import cn.skill6.website.dao.intf.article.ArticleCommentReplyDao;
import cn.skill6.website.dao.mappers.article.ArticleCommentReplyMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 文章评论回复
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-11-10 15:23
 */
@Slf4j
@Service
public class ArticleCommentReplyDaoImpl implements ArticleCommentReplyDao {

    @Autowired
    private ArticleCommentReplyMapper articleCommentReplyMapper;

    @Override
    public long insert(ArticleCommentReply articleCommentReply) {
        long replyId = SequenceManager.getNextId();
        articleCommentReply.setReplyId(replyId);
        articleCommentReply.setReplyTime(new Date());
        articleCommentReply.setReplyValid(true);

        articleCommentReplyMapper.insert(articleCommentReply);

        return replyId;
    }

    @Override
    public List<ArticleCommentReply> selectAll() {
        return articleCommentReplyMapper.selectAll();
    }

    @Override
    public List<ArticleCommentReply> selectByParam(ArticleCommentReply articleCommentReply) {
        return articleCommentReplyMapper.selectByParam(articleCommentReply);
    }
}
