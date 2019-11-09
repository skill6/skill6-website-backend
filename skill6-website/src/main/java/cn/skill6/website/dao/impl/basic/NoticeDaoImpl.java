package cn.skill6.website.dao.impl.basic;

import cn.skill6.common.entity.po.other.Notice;
import cn.skill6.website.dao.intf.basic.NoticeDao;
import cn.skill6.website.dao.mappers.basic.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统通知
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-08 20:29
 */
@Slf4j
@Repository
public class NoticeDaoImpl implements NoticeDao {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int deleteByNoticeId(Long noticeId) {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }

    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.insert(notice);
    }

    @Override
    public Notice findByNoticeId(Long noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Override
    public List<Notice> findAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public int updateByNoticeId(Notice notice) {
        return noticeMapper.updateByPrimaryKey(notice);
    }

    @Override
    public List<Notice> getLatestNotice(int topn) {
        return noticeMapper.selectAll();
    }
}
