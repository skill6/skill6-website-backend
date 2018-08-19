package cn.skill6.website.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.po.UserInfo;
import cn.skill6.common.sequence.SequenceManager;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserInfoMapperTest {

  @Autowired private UserInfoMapper userInfoMapper;

  @Autowired private StringRedisTemplate stringRedisTemplate;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoMapperTest.class);

  @Test
  public void testRedis() {
    LOGGER.info("获取redis keys {}", stringRedisTemplate.keys("*"));
  }

  @Test
  public void deleteByPrimaryKey() {}

  @Test
  @Transactional
  @Rollback
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
