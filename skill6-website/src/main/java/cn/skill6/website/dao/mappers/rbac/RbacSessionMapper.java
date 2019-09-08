package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会话信息mapper
 *
 * @author 何明胜
 * @since 2018年9月24日 上午2:44:59
 */
@Repository
public interface RbacSessionMapper {
    int deleteByPrimaryKey(Long sessionId);

    int insert(RbacSession rbacSession);

    RbacSession selectByPrimaryKey(Long sessionId);

    List<RbacSession> selectAll();

    int updateByPrimaryKey(RbacSession rbacSession);
}
