package cn.skill6.website.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import cn.skill6.common.encrypt.Md5Encrypt;
import cn.skill6.common.entity.po.FileDownload;
import cn.skill6.common.sequence.SequenceManager;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.constant.Constant;
import cn.skill6.website.dao.intf.FileDownloadOper;

/**
 * 测试文件信息数据库操作
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月4日 下午11:19:15
 */
@SpringBootTest
public class FileDownloadImpleTest extends Skill6WebsiteApplicationTest {

  @Autowired
  @Qualifier("fileDownloadImpl")
  private FileDownloadOper fileDownloadOper;

  @Test
  public void TestAddFileDownload() {
    String fileId = SequenceManager.getNextIdStr();
    String fileName = "Java虚拟机";
    String fileUrl =
        Constant.FILE_STORE_ROOT_PATH + DateFormat.formatDateYMD("yyyy/MM/dd") + "/" + fileId;
    String fileHashCode = Md5Encrypt.getMD5Code("测试");

    FileDownload fileDownload = new FileDownload();
    fileDownload.setFileId(Long.valueOf(fileId));
    fileDownload.setFileName(fileName);
    fileDownload.setFileUrl(fileUrl);
    fileDownload.setFileHashCode(fileHashCode);

    Long fileIdReturn = fileDownloadOper.addFileDownload(fileDownload);

    assertEquals(fileId, String.valueOf(fileIdReturn));
  }
}
