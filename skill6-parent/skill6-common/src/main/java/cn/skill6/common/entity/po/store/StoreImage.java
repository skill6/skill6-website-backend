package cn.skill6.common.entity.po.store;

import java.util.Date;

/**
 * 图片上传实体类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月15日 下午11:35:28
 */
public class StoreImage {
  private Long imageId;

  private String imageName;

  private String imageUrl;

  private Date imageUploadTime;

  private String imageType;

  private String imageHashCode;

  private Integer imageDownloadCount;

  @Override
  public String toString() {
    return "StoreImage [imageId="
        + imageId
        + ", imageName="
        + imageName
        + ", imageUrl="
        + imageUrl
        + ", imageUploadTime="
        + imageUploadTime
        + ", imageType="
        + imageType
        + ", imageHashCode="
        + imageHashCode
        + ", imageDownloadCount="
        + imageDownloadCount
        + "]";
  }

  public StoreImage(
      Long imageId,
      String imageName,
      String imageUrl,
      Date imageUploadTime,
      String imageType,
      String imageHashCode,
      Integer imageDownloadCount) {
    this.imageId = imageId;
    this.imageName = imageName;
    this.imageUrl = imageUrl;
    this.imageUploadTime = imageUploadTime;
    this.imageType = imageType;
    this.imageHashCode = imageHashCode;
    this.imageDownloadCount = imageDownloadCount;
  }

  public StoreImage() {
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

  public Date getImageUploadTime() {
    return imageUploadTime;
  }

  public void setImageUploadTime(Date imageUploadTime) {
    this.imageUploadTime = imageUploadTime;
  }

  public String getImageType() {
    return imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType == null ? null : imageType.trim();
  }

  public String getImageHashCode() {
    return imageHashCode;
  }

  public void setImageHashCode(String imageHashCode) {
    this.imageHashCode = imageHashCode == null ? null : imageHashCode.trim();
  }

  public Integer getImageDownloadCount() {
    return imageDownloadCount;
  }

  public void setImageDownloadCount(Integer imageDownloadCount) {
    this.imageDownloadCount = imageDownloadCount;
  }
}
