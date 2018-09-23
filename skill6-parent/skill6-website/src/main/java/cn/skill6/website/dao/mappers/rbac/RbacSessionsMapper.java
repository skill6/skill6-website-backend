package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacSessions;
import java.util.List;

public interface RbacSessionsMapper {
    int deleteByPrimaryKey(Integer sessionId);

    int insert(RbacSessions record);

    RbacSessions selectByPrimaryKey(Integer sessionId);

    List<RbacSessions> selectAll();

    int updateByPrimaryKey(RbacSessions record);
}