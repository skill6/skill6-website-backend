package cn.skill6.website.dao.mappers.rbac;

import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
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
 * 权限信息测试类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月23日 下午11:27:04
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacPermissionInfoMapperTest extends Skill6WebsiteApplicationTest {
    @Autowired
    private RbacPermissionInfoMapper rbacPermissionInfoMapper;

    private static Long permissionId = SequenceManager.getNextId();

    @Test
    public void test01Insert() {
        RbacPermissionInfo rbacPermissionInfo =
                new RbacPermissionInfo(
                        permissionId,
                        "创建用户",
                        "sys:user:create",
                        null,
                        false,
                        null,
                        new Date(),
                        new Date(),
                        true);

        rbacPermissionInfoMapper.insert(rbacPermissionInfo);
    }

    @Test
    public void test02SelectByPrimaryKey() {
        RbacPermissionInfo rbacPermissionInfo =
                rbacPermissionInfoMapper.selectByPrimaryKey(permissionId);

        assertEquals("sys:user:create", rbacPermissionInfo.getPermissionCode());
    }

    @Test
    public void test03UpdateByPrimaryKey() {
        RbacPermissionInfo rbacPermissionInfo =
                new RbacPermissionInfo(
                        permissionId,
                        "修改用户",
                        "sys:user:modify",
                        null,
                        false,
                        null,
                        new Date(),
                        new Date(),
                        true);

        rbacPermissionInfoMapper.updateByPrimaryKey(rbacPermissionInfo);
    }

    @Test
    public void test04SelectAll() {
        List<RbacPermissionInfo> rbacPermissionInfos = rbacPermissionInfoMapper.selectAll();

        assertNotEquals(null, rbacPermissionInfos);
    }

    @Test
    public void test05DeleteByPrimaryKey() {
        rbacPermissionInfoMapper.deleteByPrimaryKey(permissionId);
    }
}
