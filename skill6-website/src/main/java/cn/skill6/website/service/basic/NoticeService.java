package cn.skill6.website.service.basic;

import cn.skill6.common.entity.po.other.Notice;
import cn.skill6.website.basic.NoticeSvc;
import cn.skill6.website.dao.intf.basic.NoticeDao;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通知服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 00:44
 */
@Slf4j
@Service
@Component
public class NoticeService implements NoticeSvc {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public Notice getNotice() {
        return null;
    }

    @Override
    public List<Notice> getLatestNotice(int topn) {
        return noticeDao.getLatestNotice(topn);
    }
}
