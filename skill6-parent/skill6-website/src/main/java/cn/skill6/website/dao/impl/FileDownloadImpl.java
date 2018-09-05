package cn.skill6.website.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.FileDownload;
import cn.skill6.website.dao.FileDownloadMapper;
import cn.skill6.website.dao.intf.FileDownloadOper;

/**
 * 文件下载操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:18:06
 */
public class FileDownloadImpl implements FileDownloadOper {
  private static final Logger logger = LoggerFactory.getLogger(FileDownloadImpl.class);

  @Autowired private FileDownloadMapper fileDownloadMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.FileDownloadOper#deleteByFileId(java.lang.Long)
   */
  @Override
  public int deleteByFileId(Long fileId) {
    logger.warn("删除id为{}的文件", fileId);

    return fileDownloadMapper.deleteByPrimaryKey(fileId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.FileDownloadOper#addFileDownload(cn.skill6.common.entity.po.FileDownload)
   */
  @Override
  public int addFileDownload(FileDownload fileDownload) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.FileDownloadOper#findByFileId(java.lang.Long)
   */
  @Override
  public FileDownload findByFileId(Long fileId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.FileDownloadOper#findAll()
   */
  @Override
  public List<FileDownload> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.FileDownloadOper#modifyByFileId(cn.skill6.common.entity.po.FileDownload)
   */
  @Override
  public int modifyByFileId(FileDownload fileDownload) {
    // TODO Auto-generated method stub
    return 0;
  }
}
