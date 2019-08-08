package cn.skill6.website.dao.impl.store;

import cn.skill6.common.entity.po.store.StoreFile;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.store.StoreFileDao;
import cn.skill6.website.dao.mappers.store.StoreFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 文件存储操作实现类
 *
 * @author 何明胜
 * @version 1.7
 * @since 2018年8月28日 上午12:18:06
 */
@Slf4j
@Repository
public class StoreFileDaoImpl implements StoreFileDao {

    @Autowired
    private StoreFileMapper storeFileMapper;

    @Override
    public int deleteByFileId(Long fileId) {
        log.warn("删除id为{}的文件", fileId);
        return storeFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public Long addFileDownload(StoreFile storeFile) {
        if (storeFile == null || storeFile.getFileId() == null) {
            throw new NullPointerException("内容或者id为空");
        }

        storeFile.setFileUploadTime(new Date());
        storeFile.setFileDownloadCount(0);

        storeFileMapper.insert(storeFile);
        log.info("增加文件信息成功,{}", storeFile);

        return storeFile.getFileId();
    }

    @Override
    public StoreFile findByFileId(Long fileId) {
        StoreFile storeFile = storeFileMapper.selectByPrimaryKey(fileId);
        log.info("找到id为{}的文件下载信息,{}", fileId, storeFile);

        return storeFile;
    }

    @Override
    public List<StoreFile> findAll() {
        List<StoreFile> storeFiles = storeFileMapper.selectAll();
        log.info("找到所有文件存储记录,{}", storeFiles);

        return storeFiles;
    }

    @Override
    public void modifyByFileId(StoreFile storeFile) {
        if (storeFile.getFileId() == null) {
            throw new NullPointerException("文件存储id不能为null");
        }

        storeFileMapper.updateByPrimaryKey(storeFile);
        log.info("成功修改id为{}的文件存储记录,{}", storeFile.getFileId(), storeFile);
    }
}
