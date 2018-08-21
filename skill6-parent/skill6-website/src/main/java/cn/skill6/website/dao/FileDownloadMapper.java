package cn.skill6.website.dao;

import cn.skill6.common.entity.po.FileDownload;
import java.util.List;

/**
 * 文件下载mapper
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:40:27
 */
public interface FileDownloadMapper {
  int deleteByPrimaryKey(Long fileId);

  int insert(FileDownload record);

  FileDownload selectByPrimaryKey(Long fileId);

  List<FileDownload> selectAll();

  int updateByPrimaryKey(FileDownload record);
}
