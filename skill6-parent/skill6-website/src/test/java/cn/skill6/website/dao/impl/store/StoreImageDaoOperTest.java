package cn.skill6.website.dao.impl.store;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.po.store.StoreImage;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.store.StoreImageDao;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 测试图片存储操作
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月25日 上午12:02:43
 */
@SpringBootTest
public class StoreImageDaoOperTest extends Skill6WebsiteApplicationTest {

  @Resource(name = "storeImageDaoOper")
  StoreImageDao storeImageDao;

  @Test
  @Transactional
  public void deleteByImageId() {
    storeImageDao.deleteByImageId(SequenceManager.getNextId());
  }

  @Test(expected = cn.skill6.common.exception.general.NullPointerException.class)
  @Transactional
  public void addImageUpload() {
    storeImageDao.addImageUpload(new StoreImage());
  }

  @Test
  public void findByImageId() {}

  @Test
  public void findAll() {}

  @Test
  public void modifyByImageId() {}
}
