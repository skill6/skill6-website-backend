package cn.skill6.website.dao.impl.thirdparty;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.thirdparty.ThirdpartyAuthDao;

/**
 * 第三方登录测试
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月23日 下午11:47:28
 */
@SpringBootTest
public class ThirdpartyAuthDaoOperTest extends Skill6WebsiteApplicationTest {

  @Resource(name = "thirdpartyAuthDaoOper")
  ThirdpartyAuthDao thirdpartyAuthDao;

  public void deleteByPrimaryKey() {};

  @Test
  public void insert() {
    ThirdpartyAuth thirdpartyAuth = new ThirdpartyAuth();
    String githubId = "21255916";
    thirdpartyAuth.setThirdpartyId(1234412541L);
    thirdpartyAuth.setThirdpartyPrimaryKey(githubId);
    thirdpartyAuth.setThirdpartyValid(true);

    thirdpartyAuthDao.addThirdpartyAuth(thirdpartyAuth);
  };

  public void selectByPrimaryKey() {};

  public void selectAll() {};

  public void updateByPrimaryKey() {};

  @Test
  public void selectByParams() {
    ThirdpartyAuth thirdpartyAuth = new ThirdpartyAuth();
    String githubId = "21255916";
    thirdpartyAuth.setThirdpartyPrimaryKey(githubId);
    thirdpartyAuth.setThirdpartyValid(true);

    thirdpartyAuthDao.findByParams(thirdpartyAuth);
  };
}
