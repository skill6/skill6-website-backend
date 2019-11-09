package cn.skill6.website.util.sequence;

import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.sequence.Sequence;
import cn.skill6.website.config.Skill6PropertyConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    private Skill6PropertyConfig skill6PropertyConfig;

    /**
     * 分布式Id生成序列
     */
    private static Sequence sequence = new Sequence(0, 0);

    @PostConstruct
    public void init() {
        String workerId = skill6PropertyConfig.getSequence().getWorker().getId();
        String datacenterId = skill6PropertyConfig.getSequence().getDataCenter().getId();
        if (StringUtils.isEmpty(workerId)) {
            workerId = "0";
            log.info("workerId is empty, initialize to 0.");
        }
        if (StringUtils.isEmpty(datacenterId)) {
            datacenterId = "0";
            log.info("datacenterId is empty, initialize to 0.");
        }

        try {
            sequence = new Sequence(Long.parseLong(workerId), Long.parseLong(datacenterId));
            log.info("init sequence finished. workerId: {}, dataCenterId: {}.", workerId, datacenterId);
        } catch (NumberFormatException e) {
            sequence = new Sequence(0, 0);
            log.warn("config sequence fail, use default config", e);
        }
    }

    /**
     * @return Long类型的id
     */
    public static long getNextId() {
        for (int i = 0; i < 10; i++) {
            try {
                return sequence.nextId();
            } catch (Exception e) {
                log.warn("the {} times create id fail", i);
            }
        }

        throw new Skill6Exception("create id failed");
    }

    /**
     * @return 字符串类型的id
     */
    public static String getNextIdStr() {
        return String.valueOf(getNextId());
    }
}
