package cn.skill6.website.service.infoflow;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.infoflow.InfoFlowSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 信息流服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-08 21:45
 */
@Slf4j
@Service
@Component
public class InfoFlowService implements InfoFlowSvc {

    @Override
    public ResponseJson getLatestUpdate() {
        return null;
    }

    @Override
    public ResponseJson getMostBrowse() {
        return null;
    }

    @Override
    public ResponseJson getMostReply() {
        return null;
    }
}
