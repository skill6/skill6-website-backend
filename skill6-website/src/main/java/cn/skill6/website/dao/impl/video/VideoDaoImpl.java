package cn.skill6.website.dao.impl.video;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.po.video.VideoInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.dao.intf.video.VideoDao;
import cn.skill6.website.dao.mappers.video.VideoInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 视频信息
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-11-03 19:16
 */
@Slf4j
@Repository
public class VideoDaoImpl implements VideoDao {

    @Autowired
    private VideoInfoMapper videoInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long videoId) {
        return videoInfoMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public long insert(VideoInfo videoInfo) {
        long videoId = SequenceManager.getNextId();

        VideoInfo video = JacksonUtil.toObj(JacksonUtil.toStr(videoInfo), VideoInfo.class);
        video.setVideoId(videoId);
        video.setVideoCreateTime(new Date());
        video.setVideoUpdateTime(new Date());

        videoInfoMapper.insert(video);

        return videoId;
    }

    @Override
    public VideoInfo selectByPrimaryKey(Long videoId) {
        return videoInfoMapper.selectByPrimaryKey(videoId);
    }

    @Override
    public List<VideoInfo> selectAll() {
        return videoInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(VideoInfo videoInfo) {
        return videoInfoMapper.updateByPrimaryKey(videoInfo);
    }

    @Override
    public PageResult<VideoInfo> getVideosByPage(int pageSize, int pageNum) {
        log.info("getVideosByPage, pageSize: {}, pageNum: {}", pageSize, pageNum);

        // 设置分页数据
        Page<ArticleInfo> page = PageHelper.startPage(pageNum, pageSize);

        List<VideoInfo> videoInfos = videoInfoMapper.selectAll();
        log.info("找到视频数量：{}, 所有数量为：{}", videoInfos.size(), page.getTotal());

        return new PageResult<>(page.getTotal(), pageSize, pageNum, videoInfos);
    }
}
