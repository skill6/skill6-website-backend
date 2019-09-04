package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacSession;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * 会话测试类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午11:27:43
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacSessionsMapperTest extends Skill6WebsiteApplicationTest {
    @Autowired
    private RbacSessionMapper rbacSessionsMapper;

    private static Long sessionId = SequenceManager.getNextId();

    @Test
    public void test01Insert() {
        RbacSession rbacSessions =
                new RbacSession(sessionId, new Date(), new Date(), true, "session content");

        rbacSessionsMapper.insert(rbacSessions);
    }

    @Test
    public void test02SelectByPrimaryKey() {
        RbacSession rbacSessions = rbacSessionsMapper.selectByPrimaryKey(sessionId);

        assertEquals("session content", rbacSessions.getSessionContent());
    }

    @Test
    public void test03UpdateByPrimaryKey() {
        RbacSession rbacSessions =
                new RbacSession(sessionId, new Date(), new Date(), true, "session content1");

        rbacSessionsMapper.updateByPrimaryKey(rbacSessions);
    }

    @Test
    public void test04SelectAll() {
        List<RbacSession> rbacSessions = rbacSessionsMapper.selectAll();

        assertNotEquals(null, rbacSessions);
    }

    @Test
    public void test05DeleteByPrimaryKey() {
        rbacSessionsMapper.deleteByPrimaryKey(sessionId);
    }
}
