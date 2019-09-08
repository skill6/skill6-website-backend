package cn.skill6.website.dao.mappers.video;

import cn.skill6.common.entity.po.video.VideoInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 视频教程信息
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-01 02:36
 */
@Repository
public interface VideoInfoMapper {
    int deleteByPrimaryKey(Long videoId);

    int insert(VideoInfo videoInfo);

    VideoInfo selectByPrimaryKey(Long videoId);

    List<VideoInfo> selectAll();

    int updateByPrimaryKey(VideoInfo videoInfo);
}
