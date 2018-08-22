package cn.skill6.common.sequence;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import cn.skill6.common.sequence.SequenceManager;

/**
 * 生成分布式id作为会话id
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年4月20日 上午9:34:32
 */
public class SequenceSessionIdGenerator implements SessionIdGenerator {
  @Override
  public Serializable generateId(Session session) {
    Long userId = SequenceManager.getNextId();

    return String.valueOf(userId);
  }
}
