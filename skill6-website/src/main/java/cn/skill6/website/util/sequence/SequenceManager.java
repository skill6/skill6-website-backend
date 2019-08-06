package cn.skill6.website.util.sequence;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.common.sequence.Sequence;
import cn.skill6.website.config.Skill6Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 雪花算法管理类,产生分布式id
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年4月16日 下午10:07:43
 */
@Slf4j
@Component
public class SequenceManager {

    @Autowired
    private Skill6Properties skill6Properties;

    /**
     * 分布式Id生成序列
     */
    private static Sequence sequence = new Sequence(0, 0);

    @PostConstruct
    public void init() {
        String workerId = skill6Properties.getSequence().getWorker().getId();
        String datacenterId = skill6Properties.getSequence().getDataCenter().getId();
        if (BaseUtils.isEmpty(workerId)) {
            workerId = "0";
            log.info("workerId is empty, initialize to 0.");
        }
        if (BaseUtils.isEmpty(datacenterId)) {
            datacenterId = "0";
            log.info("datacenterId is empty, initialize to 0.");
        }

        try {
            sequence = new Sequence(Long.valueOf(workerId), Long.valueOf(datacenterId));
            log.info("init sequence finished. workerId: {}, datacenterId: {}.", workerId, datacenterId);
        } catch (NumberFormatException e) {
            sequence = new Sequence(0, 0);
            log.warn(StackTrace2Str.exceptionStackTrace2Str("config sequence fail, use default config", e));
        }
    }

    /**
     * @return Long类型的id
     */
    public static Long getNextId() {
        Long id = null;

        for (int i = 1; i < 11; i++) {
            try {
                id = sequence.nextId();
            } catch (Exception e) {
                log.warn("the {} times create id fail", i);
                continue;
            }

            break;
        }

        return id;
    }

    /**
     * @return 字符串类型的id
     */
    public static String getNextIdStr() {
        return String.valueOf(getNextId());
    }
}
