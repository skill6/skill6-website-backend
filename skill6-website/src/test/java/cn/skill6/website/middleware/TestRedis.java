package cn.skill6.website.middleware;

import cn.skill6.website.Skill6WebsiteApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis测试
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月24日 上午12:15:11
 */
@Slf4j
public class TestRedis extends Skill6WebsiteApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        log.info("获取redis keys {}", stringRedisTemplate.keys("*"));
    }
}
