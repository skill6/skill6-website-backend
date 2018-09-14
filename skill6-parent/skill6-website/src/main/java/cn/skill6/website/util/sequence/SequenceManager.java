package cn.skill6.website.util.sequence;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.exception.tools.StackTrace2Str;
import cn.skill6.common.sequence.Sequence;

/**
 * 雪花算法管理类,产生分布式id
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年4月16日 下午10:07:43
 */
@Component
public class SequenceManager {
  private static final Logger logger = LoggerFactory.getLogger(SequenceManager.class);

  /** 工作区id */
  @Value("${sequence.worker.id}")
  private String workerId;

  /** 数据中心Id */
  @Value("${sequence.datacenter.id}")
  private String datacenterId;

  /** 分布式Id生成序列 */
  private static Sequence sequence = new Sequence(0, 0);

  @PostConstruct
  public void init() {
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
    return new Long(sequence.nextId());
  }

  /**
   * 返回字符串类型的id
   *
   * @return
   */
  public static String getNextIdStr() {
    return String.valueOf(sequence.nextId());
  }
}
