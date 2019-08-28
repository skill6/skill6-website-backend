package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacUserRoleRel;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * 用户-角色关联测试类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午11:27:57
 */
public class RbacUserRoleRelMapperTest extends Skill6WebsiteApplicationTest {
    @Autowired
    private RbacUserRoleRelMapper rbacUserRoleRelMapper;

    private static Long userId = SequenceManager.getNextId();
    private static Long roleId = SequenceManager.getNextId();

    @Test
    public void test01Insert() {
        RbacUserRoleRel rbacUserRoleRel = new RbacUserRoleRel(userId, roleId);

        rbacUserRoleRelMapper.insert(rbacUserRoleRel);
    }

    @Test
    public void test02SelectAll() {
        List<RbacUserRoleRel> rbacUserRoleRels = rbacUserRoleRelMapper.selectAll();

        assertNotEquals(null, rbacUserRoleRels);
    }

    @Test
    public void test03DeleteByPrimaryKey() {
        rbacUserRoleRelMapper.deleteByPrimaryKey(userId, roleId);
    }
}
