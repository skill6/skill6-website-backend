package cn.skill6.website.dao.intf.store;

import java.util.List;

import cn.skill6.common.entity.po.store.StoreFile;

/**
 * 文件下载操作接口
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月24日 上午12:28:30
 */
public interface StoreFileDao {
  int deleteByFileId(Long fileId);

  Long addFileDownload(StoreFile storeFile);

  StoreFile findByFileId(Long fileId);

  List<StoreFile> findAll();

  int modifyByFileId(StoreFile storeFile);
}
