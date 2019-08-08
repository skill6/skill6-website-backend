package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;

import java.util.List;

/**
 * 角色信息mapper
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午10:25:34
 */
public interface RbacRoleInfoMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(RbacRoleInfo rbacRoleInfo);

    RbacRoleInfo selectByPrimaryKey(Long roleId);

    List<RbacRoleInfo> selectAll();

    int updateByPrimaryKey(RbacRoleInfo rbacRoleInfo);
}
