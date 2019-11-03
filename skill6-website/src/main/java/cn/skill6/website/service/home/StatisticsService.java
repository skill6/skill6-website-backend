package cn.skill6.website.service.home;

import cn.skill6.common.entity.po.visit.VisitStatistics;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.dao.intf.visit.VisitRecordDao;
import cn.skill6.website.dao.intf.visit.VisitStatisticsDao;
import cn.skill6.website.home.StatisticsSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

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

    @Autowired
    private VisitStatisticsDao visitStatisticsDao;

    @Autowired
    private VisitRecordDao visitRecordDao;

    @Override
    public ResponseJson getStatisticsVisit() {
        VisitStatistics visitStatistics = visitStatisticsDao.findByCurrentDate();

        return new ResponseJson(visitStatistics);
    }

    @Override
    public ResponseJson getStatisticsOnline() {
        // 查询当日访问记录数量
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date calendarTime = calendar.getTime();

        int onlineCount = visitRecordDao.getOnlineCount(calendarTime, new Date());

        return new ResponseJson(onlineCount);
    }
}
