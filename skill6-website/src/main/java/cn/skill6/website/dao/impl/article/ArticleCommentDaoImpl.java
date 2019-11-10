package cn.skill6.website.dao.impl.article;

import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.dao.intf.article.ArticleCommentDao;
import cn.skill6.website.dao.mappers.article.ArticleCommentMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 文章评论操作实现类
 *
 * @author 何明胜
 * @since 2018年8月27日 下午11:47:52
 */
@Slf4j
@Service
public class ArticleCommentDaoImpl implements ArticleCommentDao {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Override
    public int deleteByCommentId(Long commentId) {
        log.warn("删除id为{}的评论", commentId);
        return articleCommentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public long addArticleComment(ArticleComment articleComment) {
        // 设置分布id
        long commentId = SequenceManager.getNextId();
        articleComment.setCommentId(commentId);

        articleComment.setCommentTime(new Date());
        articleComment.setCommentValid(true);

        articleCommentMapper.insert(articleComment);

        log.info("增加评论成功,{}", articleComment);

        return commentId;
    }

    @Override
    public ArticleComment findByCommentId(Long commentId) {
        ArticleComment articleComment = articleCommentMapper.selectByPrimaryKey(commentId);

        log.info("找到id为{}的评论,{}", commentId, articleComment);

        return articleComment;
    }

    @Override
    public List<ArticleComment> findAll() {
        List<ArticleComment> articleComments = articleCommentMapper.selectAll();

        log.info("找到所有评论,{}", articleComments);

        return articleComments;
    }

    @Override
    public PageResult<ArticleComment> findCommentsByPage(int pageSize, int pageNum) {
        log.info("findCommentsByPage, pageSize: {}, pageNum: {}", pageSize, pageNum);

        Page<ArticleComment> page = PageHelper.startPage(pageNum, pageSize);

        List<ArticleComment> articleComments = articleCommentMapper.selectAll();
        log.info("articleComments size: {}, total: {}", articleComments.size(), page.getTotal());

        return new PageResult<>(page.getTotal(), pageSize, pageNum, articleComments);
    }

    @Override
    public int modifyByCommentId(ArticleComment articleComment) {
        // 暂不支持修改评论
        return 0;
    }

    @Override
    public PageResult<ArticleComment> getCommentsByArticleIdWithPage(
        ArticleComment articleComment, PageSortParam pageSortParam) {
        // 设置分页数据
        Page<ArticleComment> page = PageHelper.startPage(pageSortParam.getPageNum(), pageSortParam.getPageSize(),
            pageSortParam.orderBy());

        List<ArticleComment> articleComments = articleCommentMapper.selectByParams(articleComment);
        log.info("articleComments size：{}, total size：{}", articleComments.size(), page.getTotal());

        return new PageResult<>(page.getTotal(), pageSortParam.getPageSize(), pageSortParam.getPageNum(), articleComments);
    }
}
