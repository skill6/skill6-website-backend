package cn.skill6.website.middleware;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import cn.skill6.website.Skill6WebsiteApplicationTest;

/**
 * redis测试
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月24日 上午12:15:11
 */
@SpringBootTest
public class TestRedis extends Skill6WebsiteApplicationTest {
  private static final Logger logger = LoggerFactory.getLogger(TestRedis.class);

  @Autowired private StringRedisTemplate stringRedisTemplate;

  @Test
  public void testRedis() {
    logger.info("获取redis keys {}", stringRedisTemplate.keys("*"));
  }
}
