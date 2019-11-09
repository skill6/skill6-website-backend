package cn.skill6.website.dao.intf.video;

import cn.skill6.common.entity.po.video.VideoInfo;
import cn.skill6.common.entity.vo.PageResult;

import java.util.List;

public interface VideoDao {
    int deleteByPrimaryKey(Long videoId);

    long insert(VideoInfo videoInfo);

    VideoInfo selectByPrimaryKey(Long videoId);

    List<VideoInfo> selectAll();

    int updateByPrimaryKey(VideoInfo videoInfo);

    PageResult<VideoInfo> getVideosByPage(int pageSize, int pageNum);
}
