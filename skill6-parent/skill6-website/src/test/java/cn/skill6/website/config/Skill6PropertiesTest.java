package cn.skill6.website.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.skill6.website.Skill6WebsiteApplicationTest;

/**
 * spring boot测试
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月21日 下午10:04:51
 */
@SpringBootTest
public class Skill6PropertiesTest extends Skill6WebsiteApplicationTest {

  @Autowired private Skill6Properties skill6Properties;

  @Test
  public void testProperties() {
    System.out.println(skill6Properties.getGithub().getClientId());
    System.out.println(skill6Properties.getGithub().getClientSecret());

    System.out.println(skill6Properties.getQq().getClientId());
    System.out.println(skill6Properties.getQq().getRedirectUri());
    System.out.println(skill6Properties.getQq().getScope());
    System.out.println(skill6Properties.getQq().getState());
  }
}
