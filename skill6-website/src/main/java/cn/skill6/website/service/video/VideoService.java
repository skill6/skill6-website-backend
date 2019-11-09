package cn.skill6.website.service.video;

import cn.skill6.common.entity.po.video.VideoInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.dao.intf.video.VideoDao;
import cn.skill6.website.video.VideoSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 视频服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-08 21:55
 */
@Slf4j
@Service
@Component
public class VideoService implements VideoSvc {

    @Autowired
    private VideoDao videoDao;

    @Override
    public PageResult<VideoInfo> getVideosByPage(int pageSize, int pageNum) {
        return videoDao.getVideosByPage(pageSize, pageNum);
    }

    @Override
    public VideoInfo getVideoById(Long videoId) {
        return videoDao.selectByPrimaryKey(videoId);
    }

    @Override
    public long addVideo(VideoInfo videoInfo) {
        return videoDao.insert(videoInfo);
    }
}
