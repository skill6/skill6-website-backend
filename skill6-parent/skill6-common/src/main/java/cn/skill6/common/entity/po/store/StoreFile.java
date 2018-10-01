package cn.skill6.common.entity.po.store;

import java.util.Date;

import cn.skill6.common.entity.enums.FileType;

/**
 * 文件下载实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:33:07
 */
public class StoreFile {
  private Long fileId;

  private String fileName;

  private String fileUrl;

  private Date fileUploadTime;

  private FileType fileType;

  private String fileHashCode;

  private Integer fileDownloadCount;

  @Override
  public String toString() {
    return "StoreFile [fileId="
        + fileId
        + ", fileName="
        + fileName
        + ", fileUrl="
        + fileUrl
        + ", fileUploadTime="
        + fileUploadTime
        + ", fileType="
        + fileType
        + ", fileHashCode="
        + fileHashCode
        + ", fileDownloadCount="
        + fileDownloadCount
        + "]";
  }

  public StoreFile(
      Long fileId,
      String fileName,
      String fileUrl,
      Date fileUploadTime,
      FileType fileType,
      String fileHashCode,
      Integer fileDownloadCount) {
    this.fileId = fileId;
    this.fileName = fileName;
    this.fileUrl = fileUrl;
    this.fileUploadTime = fileUploadTime;
    this.fileType = fileType;
    this.fileHashCode = fileHashCode;
    this.fileDownloadCount = fileDownloadCount;
  }

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

  public StoreFile() {
    super();
  }

  public Long getFileId() {
    return fileId;
  }

  public void setFileId(Long fileId) {
    this.fileId = fileId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName == null ? null : fileName.trim();
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl == null ? null : fileUrl.trim();
  }

  public Date getFileUploadTime() {
    return fileUploadTime;
  }

  public void setFileUploadTime(Date fileUploadTime) {
    this.fileUploadTime = fileUploadTime;
  }

  public FileType getFileType() {
    return fileType;
  }

  public void setFileType(FileType fileType) {
    this.fileType = fileType;
  }

  public String getFileHashCode() {
    return fileHashCode;
  }

  public void setFileHashCode(String fileHashCode) {
    this.fileHashCode = fileHashCode == null ? null : fileHashCode.trim();
  }

  public Integer getFileDownloadCount() {
    return fileDownloadCount;
  }

  public void setFileDownloadCount(Integer fileDownloadCount) {
    this.fileDownloadCount = fileDownloadCount;
  }
}
