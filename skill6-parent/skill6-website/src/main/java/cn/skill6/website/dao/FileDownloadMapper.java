package cn.skill6.website.dao;

import cn.skill6.common.entity.po.FileDownload;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件下载mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:40:27
 */
@Mapper
public interface FileDownloadMapper {
  int deleteByPrimaryKey(Long fileId);

  int insert(FileDownload fileDownload);

  FileDownload selectByPrimaryKey(Long fileId);

  List<FileDownload> selectAll();

  int updateByPrimaryKey(FileDownload fileDownload);
}
