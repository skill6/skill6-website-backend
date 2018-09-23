package cn.skill6.website.dao;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.po.UserInfo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 用户信息测试类
 *
 * @author 刘纪春
 * @version 1.0.2
 * @since 2018年8月21日 下午11:41:17
 */
@SpringBootTest
@Transactional
public class UserInfoMapperTest extends Skill6WebsiteApplicationTest {
  private static final Logger logger = LoggerFactory.getLogger(UserInfoMapperTest.class);

  @Autowired private UserInfoMapper userInfoMapper;

  @Test
  public void testDeleteByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    userInfoMapper.deleteByPrimaryKey(id);
    logger.info("delete user {} success", id);
  }

  @Test
  public void testInsert() {
    Long id = SequenceManager.getNextId();
    logger.info("id:{}", id);
    UserInfo info = new UserInfo();
    info.setUserId(id);
    info.setUserNickName("jliu666");
    info.setUserRegisterTime(new Date());
    logger.info("{}", userInfoMapper.insert(info));
  }

  @Test
  public void testSelectByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    logger.info("{}", userInfoMapper.selectByPrimaryKey(id));
  }

  @Test
  public void testSelectAll() {
    logger.info(userInfoMapper.toString());
    logger.info("{}", userInfoMapper.selectAll());
  }

  @Test
  @Transactional
  @Rollback
  public void testUpdateByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    UserInfo info = new UserInfo();
    info.setUserId(id);
    info.setUserNickName("jliu667");
    info.setUserRegisterTime(new Date());
    logger.info("{}", userInfoMapper.updateByPrimaryKey(info));
  }
}
