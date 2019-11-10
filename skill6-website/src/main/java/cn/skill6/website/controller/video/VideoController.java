package cn.skill6.website.controller.video;

import cn.skill6.common.entity.po.video.VideoInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.video.VideoSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 视频
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 23:00
 */
@Slf4j
@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    private VideoSvc videoSvc;

    @GetMapping
    public PageResult<VideoInfo> getVideoByPage(int pageSize, int pageNum) {
        return videoSvc.getVideosByPage(pageSize, pageNum);
    }

    @GetMapping("/{videoId}")
    public VideoInfo getVideoById(@PathVariable("videoId") Long videoId) {
        return videoSvc.getVideoById(videoId);
    }

    @PostMapping
    public long addVideo(@RequestBody VideoInfo videoInfo) {
        return videoSvc.addVideo(videoInfo);
    }

}
