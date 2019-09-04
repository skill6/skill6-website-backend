package cn.skill6.website.dao.impl.store;

import cn.skill6.common.encrypt.Md5Encrypt;
import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.po.store.StoreFile;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import cn.skill6.website.config.Skill6PropertyConfig;
import cn.skill6.website.dao.intf.store.StoreFileDao;
import cn.skill6.website.util.sequence.SequenceManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * 测试文件信息数据库操作
 *
 * @author 何明胜
 * @version 1.7
 * @since 2018年9月4日 下午11:19:15
 */
public class StoreFileDaoImplTest extends Skill6WebsiteApplicationTest {

    @Autowired
    private StoreFileDao storeFileDao;

    @Autowired
    private Skill6PropertyConfig skill6PropertyConfig;

    @Test
    public void TestAddFileDownload() {
        String fileId = SequenceManager.getNextIdStr();
        String fileName = "Java虚拟机";
        String fileUrl = skill6PropertyConfig.getFilePath() +
                DateFormat.formatDateYMD("yyyy/MM/dd") + File.separator + fileId;
        String fileHashCode = Md5Encrypt.getMD5Code("测试");

        StoreFile storeFile = new StoreFile();
        storeFile.setFileId(Long.valueOf(fileId));
        storeFile.setFileName(fileName);
        storeFile.setFileUrl(fileUrl);
        storeFile.setFileHashCode(fileHashCode);
        storeFile.setFileType(FileType.ATTACHMENT);

        storeFile.setFileFullName(fileName);
        storeFile.setFileLabel("book");
        storeFile.setFileVisitCount(0);
        storeFile.setFileCollectCount(0);

        Long fileIdReturn = storeFileDao.addFileDownload(storeFile);

        assertEquals(fileId, String.valueOf(fileIdReturn));
    }
}
