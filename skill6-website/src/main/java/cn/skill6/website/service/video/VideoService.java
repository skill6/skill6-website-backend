package cn.skill6.website.service.video;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.video.VideoSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public ResponseJson getVideosByPage(int pageSize, int pageNum) {
        return null;
    }

    @Override
    public ResponseJson getVideoById(Long videoId) {
        return null;
    }
}
