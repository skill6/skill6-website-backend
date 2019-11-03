package cn.skill6.website.dao.intf.basic;

import cn.skill6.common.entity.po.other.Notice;

import java.util.List;

/**
 * 系统通知
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-08 20:29
 */
public interface NoticeDao {
    int deleteByNoticeId(Long noticeId);

    int addNotice(Notice notice);

    Notice findByNoticeId(Long noticeId);

    List<Notice> findAll();

    int updateByNoticeId(Notice notice);

    List<Notice> getLatestNotice(int topn);
}
