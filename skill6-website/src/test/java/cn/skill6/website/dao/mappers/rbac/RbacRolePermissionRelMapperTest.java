package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRolePermissionRel;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * 角色-信息关联测试类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午11:27:22
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacRolePermissionRelMapperTest extends Skill6WebsiteApplicationTest {
    @Autowired
    private RbacRolePermissionRelMapper rbacRolePermissionRelMapper;

    private static Long roleId = SequenceManager.getNextId();
    private static Long permissionId = SequenceManager.getNextId();

    @Test
    public void test01Insert() {
        RbacRolePermissionRel rbacRolePermissionRel = new RbacRolePermissionRel(roleId, permissionId);

        rbacRolePermissionRelMapper.insert(rbacRolePermissionRel);
    }

    @Test
    public void test02SelectAll() {
        List<RbacRolePermissionRel> rbacRolePermissionRels = rbacRolePermissionRelMapper.selectAll();

        assertNotEquals(null, rbacRolePermissionRels);
    }

    @Test
    public void test03DeleteByPrimaryKey() {
        rbacRolePermissionRelMapper.deleteByPrimaryKey(roleId, permissionId);
    }
}
