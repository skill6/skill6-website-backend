package cn.skill6.website.dao.impl;

import cn.skill6.common.entity.po.ImageUpload;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ImageUploadImplTest extends Skill6WebsiteApplicationTest {

  @Autowired ImageUploadImpl imageUpload;

  @Test
  @Transactional
  public void deleteByImageId() {
    imageUpload.deleteByImageId(SequenceManager.getNextId());
  }

  @Test(expected = cn.skill6.common.exception.db.NullPointerException.class)
  @Transactional
  public void addImageUpload() {
    imageUpload.addImageUpload(new ImageUpload());
  }

  @Test
  public void findByImageId() {}

  @Test
  public void findAll() {}

  @Test
  public void modifyByImageId() {}
}
