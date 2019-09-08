package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色信息mapper
 *
 * @author 何明胜
 * @since 2018年9月23日 下午10:25:34
 */
@Repository
public interface RbacRoleInfoMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(RbacRoleInfo rbacRoleInfo);

    RbacRoleInfo selectByPrimaryKey(Long roleId);

    List<RbacRoleInfo> selectAll();

    int updateByPrimaryKey(RbacRoleInfo rbacRoleInfo);
}
