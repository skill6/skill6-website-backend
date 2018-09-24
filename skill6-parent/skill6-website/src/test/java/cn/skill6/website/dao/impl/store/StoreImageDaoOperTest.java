package cn.skill6.website.dao.impl.store;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @version 1.0.0
 * @since 2018年9月25日 上午12:02:43
 */
@SpringBootTest
public class StoreImageDaoOperTest extends Skill6WebsiteApplicationTest {

  @Autowired
  @Qualifier("storeImageDaoOper")
  StoreImageDao storeImageOper;

  @Test
  @Transactional
  public void deleteByImageId() {
    storeImageOper.deleteByImageId(SequenceManager.getNextId());
  }

  @Test(expected = cn.skill6.common.exception.db.NullPointerException.class)
  @Transactional
  public void addImageUpload() {
    storeImageOper.addImageUpload(new StoreImage());
  }

  @Test
  public void findByImageId() {}

  @Test
  public void findAll() {}

  @Test
  public void modifyByImageId() {}
}
