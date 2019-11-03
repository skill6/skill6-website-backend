package cn.skill6.website.controller.video;

import cn.skill6.common.entity.po.video.VideoInfo;
import cn.skill6.website.video.VideoSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 视频
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 23:00
 */
@Slf4j
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoSvc videoSvc;

    @GetMapping
    public List<VideoInfo> getVideos(int pageSize, int pageNum) {
        return videoSvc.getVideosByPage(pageSize, pageNum);
    }

    @GetMapping("/{videoId}")
    public VideoInfo getVideoById(@PathVariable("videoId") Long videoId) {
        return videoSvc.getVideoById(videoId);
    }

}
