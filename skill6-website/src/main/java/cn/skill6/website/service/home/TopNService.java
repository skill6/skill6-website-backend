package cn.skill6.website.service.home;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.intf.user.UserDao;
import cn.skill6.website.home.TopNSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAdditionInfoDao userAdditionInfoDao;

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
