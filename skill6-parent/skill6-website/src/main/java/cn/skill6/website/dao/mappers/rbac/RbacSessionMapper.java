package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacSession;
import java.util.List;

/**
 * 会话信息mapper
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月24日 上午2:44:59
 */
public interface RbacSessionMapper {
  int deleteByPrimaryKey(Long sessionId);

  int insert(RbacSession rbacSession);

  RbacSession selectByPrimaryKey(Long sessionId);

  List<RbacSession> selectAll();

  int updateByPrimaryKey(RbacSession rbacSession);
}
