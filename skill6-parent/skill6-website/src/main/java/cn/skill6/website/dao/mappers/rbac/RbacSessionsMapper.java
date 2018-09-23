package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacSessions;
import java.util.List;

/**
 * 会话信息mapper
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月23日 下午10:26:47
 */
public interface RbacSessionsMapper {
  int deleteByPrimaryKey(Long sessionId);

  int insert(RbacSessions rbacSessions);

  RbacSessions selectByPrimaryKey(Long sessionId);

  List<RbacSessions> selectAll();

  int updateByPrimaryKey(RbacSessions rbacSessions);
}
