package cn.skill6.website.config;

import cn.skill6.website.Skill6WebsiteApplicationBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * spring boot测试
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年11月21日 下午10:04:51
 */
public class Skill6PropertiesTest extends Skill6WebsiteApplicationBase {

    @Autowired
    private Skill6Properties skill6Properties;

    @Test
    public void testProperties() {
        System.out.println(skill6Properties.getGitHub().getClientId());
        System.out.println(skill6Properties.getGitHub().getClientSecret());

        System.out.println(skill6Properties.getQq().getClientId());
        System.out.println(skill6Properties.getQq().getRedirectUri());
        System.out.println(skill6Properties.getQq().getScope());
        System.out.println(skill6Properties.getQq().getState());
    }
}
