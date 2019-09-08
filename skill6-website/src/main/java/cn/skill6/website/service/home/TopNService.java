package cn.skill6.website.service.home;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.home.TopNSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * top n 服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 01:04
 */
@Slf4j
@Service
@Component
public class TopNService implements TopNSvc {

    @Override
    public ResponseJson getActiveUsers() {
        return null;
    }

    @Override
    public ResponseJson getTrafficUsers() {
        return null;
    }

    @Override
    public ResponseJson getPublishArticles() {
        return null;
    }
}
