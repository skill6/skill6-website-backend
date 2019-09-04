package cn.skill6.website.dao.impl.rbac;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.website.dao.intf.rbac.RbacRoleDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色信息操作实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月25日 下午7:03:41
 */
@Repository
public class RbacRoleDaoImpl implements RbacRoleDao {

    @Override
    public int deleteByRoleId(Long roleId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addRbacRoleInfo(RbacRoleInfo rbacRoleInfo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RbacRoleInfo findByPrimaryKey(Long roleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RbacRoleInfo> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int modifyByRoleId(RbacRoleInfo rbacRoleInfo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<RbacPermissionInfo> findPermissionByRoleIds(List<Long> roleIds) {
        // TODO Auto-generated method stub
        return null;
    }
}
