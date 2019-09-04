package cn.skill6.website.dao.impl.thirdparty;

import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.thirdparty.ThirdpartyAuthDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 第三方登录测试
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月23日 下午11:47:28
 */
public class ThirdpartyAuthDaoImplTest extends Skill6WebsiteApplicationTest {

    @Autowired
    ThirdpartyAuthDao thirdpartyAuthDao;

    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        ThirdpartyAuth thirdpartyAuth = new ThirdpartyAuth();
        String githubId = "21255916";
        thirdpartyAuth.setThirdpartyPrimaryKey(githubId);
        thirdpartyAuth.setUserId(986969L);
        thirdpartyAuth.setThirdpartyValid(true);

        thirdpartyAuthDao.addThirdpartyAuth(thirdpartyAuth);
    }

    public void selectByPrimaryKey() {
    }

    public void selectAll() {
    }

    public void updateByPrimaryKey() {
    }

    @Test
    public void selectByParams() {
        ThirdpartyAuth thirdpartyAuth = new ThirdpartyAuth();
        String githubId = "21255916";
        thirdpartyAuth.setThirdpartyPrimaryKey(githubId);
        thirdpartyAuth.setThirdpartyValid(true);

        thirdpartyAuthDao.findByParams(thirdpartyAuth);
    }

}
