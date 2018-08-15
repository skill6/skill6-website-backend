package cn.skill6.common.entity.po;

import java.util.Date;

/**
 * 图片上传实体类
 *
 * @author 何明胜
 * @created at 2018年8月15日 下午11:35:28
 * @version 1.0.0
 */
public class ImageUpload {
  private Long imageId;

  private String imageName;

  private String imageUrl;

  private Date imageUploadDate;

  private String imageType;

  private Integer imageDownloadCount;

  public ImageUpload(
      Long imageId,
      String imageName,
      String imageUrl,
      Date imageUploadDate,
      String imageType,
      Integer imageDownloadCount) {
    this.imageId = imageId;
    this.imageName = imageName;
    this.imageUrl = imageUrl;
    this.imageUploadDate = imageUploadDate;
    this.imageType = imageType;
    this.imageDownloadCount = imageDownloadCount;
  }

  public ImageUpload() {
    super();
  }

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName == null ? null : imageName.trim();
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl == null ? null : imageUrl.trim();
  }

  public Date getImageUploadDate() {
    return imageUploadDate;
  }

  public void setImageUploadDate(Date imageUploadDate) {
    this.imageUploadDate = imageUploadDate;
  }

  public String getImageType() {
    return imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType == null ? null : imageType.trim();
  }

  public Integer getImageDownloadCount() {
    return imageDownloadCount;
  }

  public void setImageDownloadCount(Integer imageDownloadCount) {
    this.imageDownloadCount = imageDownloadCount;
  }
}
