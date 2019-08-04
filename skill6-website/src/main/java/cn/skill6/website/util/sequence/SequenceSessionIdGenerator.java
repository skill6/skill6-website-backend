package cn.skill6.website.util.sequence;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 生成分布式id作为会话id
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年4月20日 上午9:34:32
 */
@Component
public class SequenceSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        String sequenceId = SequenceManager.getNextIdStr();

        return sequenceId;
    }
}
