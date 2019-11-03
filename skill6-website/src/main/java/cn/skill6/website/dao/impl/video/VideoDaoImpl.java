package cn.skill6.website.dao.impl.video;

import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.po.video.VideoInfo;
import cn.skill6.website.dao.intf.video.VideoDao;
import cn.skill6.website.dao.mappers.video.VideoInfoMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public int insert(VideoInfo videoInfo) {
        return videoInfoMapper.insert(videoInfo);
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
    public List<VideoInfo> getVideosByPage(int pageSize, int pageNum) {
        // 设置分页数据
        Page<ArticleInfo> page = PageHelper.startPage(pageNum, pageSize);

        List<VideoInfo> videoInfos = videoInfoMapper.selectAll();
        log.info("找到视频数量：{}, 所有数量为：{}", videoInfos.size(), page.getTotal());

        return videoInfos;
    }
}
