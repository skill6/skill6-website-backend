package cn.skill6.website.dao.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cn.skill6.common.entity.po.store.StoreImage;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.dao.intf.store.StoreImageOper;
import cn.skill6.website.util.sequence.SequenceManager;

@SpringBootTest
public class ImageUploadImplTest extends Skill6WebsiteApplicationTest {

  @Autowired
  @Qualifier("storeImageImpl")
  StoreImageOper storeImageOper;

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
