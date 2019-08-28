package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * 角色信息测试类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午11:27:14
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacRoleInfoMapperTest extends Skill6WebsiteApplicationTest {
    @Autowired
    private RbacRoleInfoMapper rbacRoleInfoMapper;

    private static Long roleId = SequenceManager.getNextId();

    @Test
    public void test01Insert() {
        RbacRoleInfo rbacRoleInfo =
                new RbacRoleInfo(roleId, "管理员", "admin", null, new Date(), new Date(), true);
        rbacRoleInfoMapper.insert(rbacRoleInfo);
    }

    @Test
    public void test02SelectByPrimaryKey() {
        RbacRoleInfo rbacRoleInfo = rbacRoleInfoMapper.selectByPrimaryKey(roleId);

        assertEquals("admin", rbacRoleInfo.getRoleCode());
    }

    @Test
    public void test03UpdateByPrimaryKey() {
        RbacRoleInfo rbacRoleInfo =
                new RbacRoleInfo(roleId, "用户", "user", null, new Date(), new Date(), true);

        rbacRoleInfoMapper.updateByPrimaryKey(rbacRoleInfo);
    }

    @Test
    public void test04SelectAll() {
        List<RbacRoleInfo> rbacRoleInfos = rbacRoleInfoMapper.selectAll();

        assertNotEquals(null, rbacRoleInfos);
    }

    @Test
    public void test05DeleteByPrimaryKey() {
        rbacRoleInfoMapper.deleteByPrimaryKey(roleId);
    }
}
