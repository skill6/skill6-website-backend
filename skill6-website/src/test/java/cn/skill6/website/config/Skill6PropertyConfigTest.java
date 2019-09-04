package cn.skill6.website.config;

import cn.skill6.website.Skill6WebsiteApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * spring boot测试
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年11月21日 下午10:04:51
 */
public class Skill6PropertyConfigTest extends Skill6WebsiteApplicationTest {

    @Autowired
    private Skill6PropertyConfig skill6PropertyConfig;

    @Test
    public void testProperties() {
        System.out.println(skill6PropertyConfig.getGitHub().getClientId());
        System.out.println(skill6PropertyConfig.getGitHub().getClientSecret());

        System.out.println(skill6PropertyConfig.getQq().getClientId());
        System.out.println(skill6PropertyConfig.getQq().getRedirectUri());
        System.out.println(skill6PropertyConfig.getQq().getScope());
        System.out.println(skill6PropertyConfig.getQq().getState());
    }
}
