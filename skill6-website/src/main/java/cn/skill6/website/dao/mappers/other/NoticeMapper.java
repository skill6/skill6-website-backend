package cn.skill6.website.dao.mappers.other;

import cn.skill6.common.entity.po.other.Notice;

import java.util.List;

/**
 * 通知信息mapper
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-01 02:29
 */
public interface NoticeMapper {
    int deleteByPrimaryKey(Long noticeId);

    int insert(Notice notice);

    Notice selectByPrimaryKey(Long noticeId);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice notice);
}
