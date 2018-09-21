package cn.skill6.website.util.sequence;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.common.sequence.Sequence;
import cn.skill6.website.config.Skill6Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 雪花算法管理类,产生分布式id
 *
 * @author 何明胜
 * @version 1.0.4
 * @since 2018年4月16日 下午10:07:43
 */
@Component
public class SequenceManager {
  private static final Logger logger = LoggerFactory.getLogger(SequenceManager.class);

  @Autowired private Skill6Properties skill6Properties;

  /** 分布式Id生成序列 */
  private static Sequence sequence = new Sequence(0, 0);

  @PostConstruct
  public void init() {
    String workerId = skill6Properties.getSequence().getWorker().getId();
    String datacenterId = skill6Properties.getSequence().getDataCenter().getId();
    if (BaseUtils.isEmpty(workerId)) {
      workerId = "0";
      logger.info("workerId is empty, initialize to 0.");
    }
    if (BaseUtils.isEmpty(datacenterId)) {
      datacenterId = "0";
      logger.info("datacenterId is empty, initialize to 0.");
    }

    try {
      sequence = new Sequence(Long.valueOf(workerId), Long.valueOf(datacenterId));
      logger.info("初始化sequence完成. workerId: {}, datacenterId: {}.", workerId, datacenterId);
    } catch (NumberFormatException e) {
      sequence = new Sequence(0, 0);
      logger.warn(StackTrace2Str.exceptionStackTrace2Str("配置sequence失败，采用默认配置", e));
    }
  }

  /**
   * 返回Long类型的id
   *
   * @return
   */
  public static Long getNextId() {
    Long id = null;

    for (int i = 1; i < 11; i++) {
      try {
        id = sequence.nextId();
      } catch (Exception e) {
        logger.warn("第{}次生成id失败", i);
        continue;
      }

      break;
    }

    return id;
  }

  /**
   * 返回字符串类型的id
   *
   * @return
   */
  public static String getNextIdStr() {
    return String.valueOf(getNextId());
  }
}
