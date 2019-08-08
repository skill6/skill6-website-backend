package cn.skill6.website.dao.intf.rbac;

import cn.skill6.common.entity.po.rbac.RbacSession;

import java.util.List;

/**
 * 会话操作接口
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月23日 下午10:48:43
 */
public interface RbacSessionsDao {
    int deleteByPrimaryKey(Long sessionId);

    int addRbacSessions(RbacSession rbacSessions);

    RbacSession findByPrimaryKey(Long sessionId);

    List<RbacSession> findAll();

    int modifyByPrimaryKey(RbacSession rbacSessions);
}
