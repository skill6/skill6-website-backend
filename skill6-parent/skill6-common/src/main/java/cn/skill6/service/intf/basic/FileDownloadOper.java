package cn.skill6.service.intf.basic;

import java.util.List;

import cn.skill6.common.entity.po.FileDownload;

/**
 * 文件下载操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:28:30
 */
public interface FileDownloadOper {
  int deleteByFileId(Long fileId);

  int addFileDownload(FileDownload fileDownload);

  FileDownload findByFileId(Long fileId);

  List<FileDownload> findAll();

  int modifyByFileId(FileDownload fileDownload);
}
