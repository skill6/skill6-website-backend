package cn.skill6.website.dao.intf.store;

import cn.skill6.common.entity.po.store.StoreFile;

import java.util.List;

/**
 * 文件下载操作接口
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月24日 上午12:28:30
 */
public interface StoreFileDao {
    int deleteByFileId(Long fileId);

    Long addFileDownload(StoreFile storeFile);

    StoreFile findByFileId(Long fileId);

    List<StoreFile> findAll();

    void modifyByFileId(StoreFile storeFile);
}
