package cn.skill6.website.dao.impl.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import cn.skill6.common.encrypt.Md5Encrypt;
import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.po.store.StoreFile;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.config.Skill6Properties;
import cn.skill6.website.dao.intf.store.StoreFileOper;
import cn.skill6.website.util.sequence.SequenceManager;

/**
 * 测试文件信息数据库操作
 *
 * @author 何明胜
 * @version 1.0.5
 * @since 2018年9月4日 下午11:19:15
 */
@SpringBootTest
public class StoreFileImplTest extends Skill6WebsiteApplicationTest {

  @Autowired
  @Qualifier("storeFileImpl")
  private StoreFileOper storeFileOper;

  @Autowired private Skill6Properties skill6Properties;

  @Test
  public void TestAddFileDownload() {
    String fileId = SequenceManager.getNextIdStr();
    String fileName = "Java虚拟机";
    String fileUrl =
        skill6Properties.getFilePath() + DateFormat.formatDateYMD("yyyy/MM/dd") + "/" + fileId;
    String fileHashCode = Md5Encrypt.getMD5Code("测试");

    StoreFile storeFile = new StoreFile();
    storeFile.setFileId(Long.valueOf(fileId));
    storeFile.setFileName(fileName);
    storeFile.setFileUrl(fileUrl);
    storeFile.setFileHashCode(fileHashCode);
    storeFile.setFileType(FileType.ATTACHMENT);

    Long fileIdReturn = storeFileOper.addFileDownload(storeFile);

    assertEquals(fileId, String.valueOf(fileIdReturn));
  }
}
