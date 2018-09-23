package cn.skill6.website.dao.impl;

import cn.skill6.common.entity.po.FileDownload;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileDownloadImplTest extends Skill6WebsiteApplicationTest {

  @Autowired private FileDownloadImpl fileDownload;

  @Test
  public void deleteByFileId() {
    fileDownload.deleteByFileId(SequenceManager.getNextId());
  }

  @Test(expected = cn.skill6.common.exception.db.NullPointerException.class)
  public void addFileDownload() {
    fileDownload.addFileDownload(new FileDownload());
  }

  @Test
  public void findByFileId() {}

  @Test
  public void findAll() {}

  @Test
  public void modifyByFileId() {}
}
