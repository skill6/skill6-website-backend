package cn.skill6.website.service.article;

import cn.skill6.common.entity.enums.SortType;
import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleComment;
import cn.skill6.common.entity.po.article.ArticleCommentReply;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.entity.to.article.ArticleCommentTo;
import cn.skill6.common.entity.to.article.ArticleInfoTo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.entity.vo.article.ArticleCommentReplyVo;
import cn.skill6.common.entity.vo.article.ArticleCommentVo;
import cn.skill6.common.entity.vo.article.ArticleInfoVo;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.article.ArticleSvc;
import cn.skill6.website.dao.intf.article.ArticleCommentDao;
import cn.skill6.website.dao.intf.article.ArticleCommentReplyDao;
import cn.skill6.website.dao.intf.article.ArticleDao;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章信息代理服务类，处理Controller转发过来的RestFul请求
 *
 * @author 何明胜
 * @since 2018年8月21日 下午11:07:30
 */
@Slf4j
@Service
@Component
public class ArticleService implements ArticleSvc {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleCommentDao articleCommentDao;

    @Autowired
    private UserAdditionInfoDao userAdditionInfoDao;

    @Autowired
    private ArticleCommentReplyDao articleCommentReplyDao;

    @Autowired
    private ArticleInfoTo articleInfoTo;

    @Autowired
    private ArticleCommentTo articleCommentTo;

    @Override
    public long addArticle(ArticleInfo articleInfo) {
        return articleDao.addArticleInfo(articleInfo);
    }

    @Override
    public int deleteArticleById(Long articleId) {
        return articleDao.deleteByPrimaryKey(articleId);
    }

    @Override
    public ResponseJson modifyArticleById(ArticleInfo articleInfo) {
        articleDao.modifyByArticleId(articleInfo);
        return ResponseJson.build("修改成功");
    }

    @Override
    public ArticleInfo getArticleById(Long articleId) {
        return articleDao.findByArticleId(articleId);
    }

    @Override
    public List<ArticleInfo> getAllArticles() {
        return articleDao.findAll();
    }

    @Override
    public PageResult<ArticleInfoVo> getArticlesByPage(int pageSize, int pageNum) {
        PageSortParam pageSortParam = PageSortParam.builder()
            .pageSize(pageSize)
            .pageNum(pageNum)
            .orderBy(articleInfoTo.getArticleCreateTime())
            .sortType(SortType.DESCENDING).build();

        PageResult<ArticleInfo> articleInfoPage = articleDao.findByParamWithPage(new ArticleInfo(), pageSortParam);
        List<ArticleInfo> articleInfos = articleInfoPage.getData();

        List<ArticleInfoVo> articleInfoVos = articleInfos.stream()
            .map(this::buildArticleInfoVo)
            .collect(Collectors.toList());

        return new PageResult<>(articleInfoPage.getTotal(), pageSize, pageNum, articleInfoVos);
    }

    @Override
    public PageResult<ArticleCommentVo> getCommentsByArticleIdWithPage(long articleId, int pageSize, int pageNum) {
        PageSortParam pageSortParam = PageSortParam.builder()
            .pageSize(pageSize)
            .pageNum(pageNum)
            .orderBy(articleCommentTo.getCommentTime())
            .sortType(SortType.DESCENDING).build();

        ArticleComment articleComment = ArticleComment.builder().articleId(articleId).build();

        // 查询当前分页的所有评论
        PageResult<ArticleComment> commentsByArticleIdWithPage = articleCommentDao.
            getCommentsByArticleIdWithPage(articleComment, pageSortParam);

        List<ArticleCommentVo> articleCommentVos = commentsByArticleIdWithPage.getData()
            .stream()
            .map(this::buildArticleCommentVo)
            .collect(Collectors.toList());
        log.info("articleCommentVos: {}", JacksonUtil.toStr(articleCommentVos));

        return new PageResult<>(commentsByArticleIdWithPage.getTotal(), pageSize, pageNum, articleCommentVos);
    }

    private ArticleInfoVo buildArticleInfoVo(ArticleInfo articleInfo) {
        ArticleInfoVo articleInfoVo = JacksonUtil.toObj(JacksonUtil.toStr(articleInfo), ArticleInfoVo.class);
        // TODO 根据用户ID查询用户信息
        articleInfoVo.setUserHeadUrl("https://www.hemingsheng.cn/imageDownload.hms?imageUrl=20190623/80059000.jpeg");

        return articleInfoVo;
    }


    private ArticleCommentVo buildArticleCommentVo(ArticleComment articleComment) {
        long commentUserId = articleComment.getCommentUserId();
        // 查询评论用户的信息
        UserAdditionInfo commentUserAddition = userAdditionInfoDao.findByUserId(commentUserId);

        // 查询所有对评论的回复
        long commentId = articleComment.getCommentId();
        ArticleCommentReply articleCommentReply = ArticleCommentReply.builder().commentId(commentId).build();
        List<ArticleCommentReply> articleCommentReplyList = articleCommentReplyDao.selectByParam(articleCommentReply);
        List<ArticleCommentReplyVo> articleCommentReplyVos = articleCommentReplyList
            .stream()
            .map(this::buildArticleCommentReplyVo)
            .collect(Collectors.toList());

        return ArticleCommentVo.builder().commentId(String.valueOf(articleComment.getCommentId()))
            .articleId(articleComment.getArticleId())
            .commentTime(articleComment.getCommentTime())
            .commentUserId(articleComment.getCommentUserId())
            .commentUserNickName(commentUserAddition.getUserNickName())
            .commentUserHeadUrl(commentUserAddition.getUserHeadUrl())
            .commentThumbsUpCount(articleComment.getCommentThumbsUpCount())
            .commentContent(articleComment.getCommentContent())
            .articleCommentReplyVos(articleCommentReplyVos)
            .build();
    }

    private ArticleCommentReplyVo buildArticleCommentReplyVo(ArticleCommentReply articleCommentReply) {
        // 查询回复评论的用户的信息
        long replyUserId = articleCommentReply.getReplyUserId();
        UserAdditionInfo replyUserAddition = userAdditionInfoDao.findByUserId(replyUserId);

        long replyToUserId = articleCommentReply.getReplyToUserId();
        UserAdditionInfo replyToUserAddition = userAdditionInfoDao.findByUserId(replyToUserId);

        return ArticleCommentReplyVo.builder().replyId(String.valueOf(articleCommentReply.getReplyId()))
            .commentId(articleCommentReply.getCommentId())
            .replyUserId(articleCommentReply.getReplyUserId())
            .replyUserNickName(replyUserAddition.getUserNickName())
            .replyUserHeadUrl(replyUserAddition.getUserHeadUrl())
            .replyToUserId(articleCommentReply.getReplyToUserId())
            .replyToUserNickName(replyToUserAddition.getUserNickName())
            .replyToUserHeadUrl(replyToUserAddition.getUserHeadUrl())
            .replyTime(articleCommentReply.getReplyTime())
            .replyContent(articleCommentReply.getReplyContent())
            .build();
    }
}
