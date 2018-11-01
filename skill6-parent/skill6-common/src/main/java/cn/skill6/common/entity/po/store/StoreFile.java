package cn.skill6.common.entity.po.store;

import java.util.Date;

import cn.skill6.common.entity.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件下载实体类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月15日 下午11:33:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreFile {

  private Long fileId;

  private String fileName;

  private String fileUrl;

  private Date fileUploadTime;

  private FileType fileType;

  private String fileHashCode;

  private Integer fileDownloadCount;

  public StoreFile(
      Long fileId,
      String fileName,
      String fileUrl,
      Date fileUploadTime,
      String fileHashCode,
      Integer fileDownloadCount) {
    this.fileId = fileId;
    this.fileName = fileName;
    this.fileUrl = fileUrl;
    this.fileUploadTime = fileUploadTime;
    this.fileHashCode = fileHashCode;
    this.fileDownloadCount = fileDownloadCount;
  }
}
