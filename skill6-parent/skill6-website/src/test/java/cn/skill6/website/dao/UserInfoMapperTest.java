package cn.skill6.website.dao;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.po.UserInfo;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 用户信息测试类
 *
 * @author 刘纪春
 * @version 1.0.1
 * @since 2018年8月21日 下午11:41:17
 */
@SpringBootTest
public class UserInfoMapperTest extends Skill6WebsiteApplicationTest {

  @Autowired private UserInfoMapper userInfoMapper;

  @Autowired private StringRedisTemplate stringRedisTemplate;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoMapperTest.class);

  @Test
  public void testRedis() {
    LOGGER.info("获取redis keys {}", stringRedisTemplate.keys("*"));
  }

  @Test
  public void deleteByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    userInfoMapper.deleteByPrimaryKey(id);
    LOGGER.info("delete user {} success", id);
  }

  @Test
  public void insert() {
    Long id = SequenceManager.getNextId();
    LOGGER.info("id:{}", id);
    UserInfo info = new UserInfo();
    info.setUserId(id);
    info.setUserNickName("jliu666");
    info.setUserRegisterTime(new Date());
    LOGGER.info("{}", userInfoMapper.insert(info));
  }

  @Test
  public void selectByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    LOGGER.info("{}", userInfoMapper.selectByPrimaryKey(id));
  }

  @Test
  public void selectAll() {
    LOGGER.info(userInfoMapper.toString());
    LOGGER.info("{}", userInfoMapper.selectAll());
  }

  @Test
  @Transactional
  @Rollback
  public void updateByPrimaryKey() {
    Long id = SequenceManager.getNextId();
    UserInfo info = new UserInfo();
    info.setUserId(id);
    info.setUserNickName("jliu667");
    info.setUserRegisterTime(new Date());
    LOGGER.info("{}", userInfoMapper.updateByPrimaryKey(info));
  }
}
