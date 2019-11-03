package cn.skill6.website.service.infoflow;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.website.dao.intf.article.ArticleDao;
import cn.skill6.website.infoflow.InfoFlowSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 信息流服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-08 21:45
 */
@Slf4j
@Service
@Component
public class InfoFlowService implements InfoFlowSvc {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<ArticleInfo> getLatestUpdate() {
        List<ArticleInfo> articles = articleDao.findAll();

        return articles.stream()
            .sorted(Comparator.comparing(ArticleInfo::getArticleUpdateTime))
            .collect(Collectors.toList());
    }

    @Override
    public List<ArticleInfo> getMostBrowse() {
        List<ArticleInfo> articles = articleDao.findAll();

        return articles.stream()
            .sorted(Comparator.comparing(ArticleInfo::getArticleUpdateTime))
            .collect(Collectors.toList());
    }

    @Override
    public List<ArticleInfo> getMostReply() {
        List<ArticleInfo> articles = articleDao.findAll();

        return articles.stream()
            .sorted(Comparator.comparing(ArticleInfo::getArticleUpdateTime))
            .collect(Collectors.toList());
    }
}
