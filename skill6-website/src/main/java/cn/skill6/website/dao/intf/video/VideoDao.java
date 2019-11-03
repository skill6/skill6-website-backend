package cn.skill6.website.dao.intf.video;

import cn.skill6.common.entity.po.video.VideoInfo;

import java.util.List;

public interface VideoDao {
    int deleteByPrimaryKey(Long videoId);

    int insert(VideoInfo videoInfo);

    VideoInfo selectByPrimaryKey(Long videoId);

    List<VideoInfo> selectAll();

    int updateByPrimaryKey(VideoInfo videoInfo);

    List<VideoInfo> getVideosByPage(int pageSize, int pageNum);
}
