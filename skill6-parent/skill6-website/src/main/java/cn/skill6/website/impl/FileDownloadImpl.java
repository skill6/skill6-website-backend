package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.FileDownload;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:18:06
 */
public class FileDownloadImpl implements cn.skill6.service.intf.basic.FileDownloadOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.FileDownloadOper#deleteByFileId(java.lang.Long)
   */
  @Override
  public int deleteByFileId(Long fileId) {
    // TODO Auto-generated method stub
    return 0;
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
