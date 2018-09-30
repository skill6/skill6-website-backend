package cn.skill6.website.dao.mappers.user;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.mappers.user.UserAdditionInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 用户信息测试类
 *
 * @author 刘纪春
 * @version 1.3
 * @since 2018年8月21日 下午11:41:17
 */
@SpringBootTest
@Transactional
public class UserAdditionInfoTest extends Skill6WebsiteApplicationTest {
  private static final Logger logger = LoggerFactory.getLogger(UserAdditionInfoTest.class);

  @Autowired private UserAdditionInfoMapper userAdditionInfoMapper;

  @Test
  public void testDeleteByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    userAdditionInfoMapper.deleteByPrimaryKey(id);
    logger.info("delete user {} success", id);
  }

  @Test
  public void testInsert() {
    Long id = SequenceManager.getNextId();
    logger.info("id:{}", id);
    UserAdditionInfo userAdditionInfo = new UserAdditionInfo();
    userAdditionInfo.setUserId(id);
    userAdditionInfo.setUserNickName("jliu666");
    userAdditionInfo.setUserRegisterTime(new Date());
    logger.info("{}", userAdditionInfoMapper.insert(userAdditionInfo));
  }

  @Test
  public void testSelectByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    logger.info("{}", userAdditionInfoMapper.selectByPrimaryKey(id));
  }

  @Test
  public void testSelectAll() {
    logger.info("{}", userAdditionInfoMapper.selectAll());
  }

  @Test
  @Transactional
  @Rollback
  public void testUpdateByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    UserAdditionInfo userAdditionInfo = new UserAdditionInfo();
    userAdditionInfo.setUserId(id);
    userAdditionInfo.setUserNickName("jliu667");
    userAdditionInfo.setUserRegisterTime(new Date());
    logger.info("{}", userAdditionInfoMapper.updateByPrimaryKey(userAdditionInfo));
  }
}
