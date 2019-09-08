package cn.skill6.website.service.home;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.home.StatisticsSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 统计服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 00:59
 */
@Slf4j
@Service
@Component
public class StatisticsService implements StatisticsSvc {

    @Override
    public ResponseJson getStatisticsVisit() {
        return null;
    }

    @Override
    public ResponseJson getStatisticsOnline() {
        return null;
    }
}
