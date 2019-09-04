package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 用户信息测试类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-27 00:45
 */
@Slf4j
@Transactional
public class UserAdditionInfoTest extends Skill6WebsiteApplicationTest {

    @Autowired
    private UserAdditionInfoMapper userAdditionInfoMapper;

    @Test
    public void testDeleteByPrimaryKey() {
        Long id = SequenceManager.getNextId();
        userAdditionInfoMapper.deleteByPrimaryKey(id);
        log.info("delete user {} success", id);
    }

    @Test
    public void testInsert() {
        Long id = SequenceManager.getNextId();
        log.info("id:{}", id);
        UserAdditionInfo userAdditionInfo = new UserAdditionInfo();
        userAdditionInfo.setUserId(id);
        userAdditionInfo.setUserNickName("testUser");
        userAdditionInfo.setUserRegisterDate(new Date());
        log.info("{}", userAdditionInfoMapper.insert(userAdditionInfo));
    }

    @Test
    public void testSelectByPrimaryKey() {
        Long id = SequenceManager.getNextId();
        log.info("{}", userAdditionInfoMapper.selectByPrimaryKey(id));
    }

    @Test
    public void testSelectAll() {
        log.info("{}", userAdditionInfoMapper.selectAll());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateByPrimaryKey() {
        Long id = SequenceManager.getNextId();
        UserAdditionInfo userAdditionInfo = new UserAdditionInfo();
        userAdditionInfo.setUserId(id);
        userAdditionInfo.setUserNickName("testUser");
        userAdditionInfo.setUserRegisterDate(new Date());
        log.info("{}", userAdditionInfoMapper.updateByPrimaryKey(userAdditionInfo));
    }
}
