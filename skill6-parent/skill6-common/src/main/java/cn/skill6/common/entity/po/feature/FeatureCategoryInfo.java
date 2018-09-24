package cn.skill6.common.entity.po.feature;

import java.util.Date;

import cn.skill6.common.entity.enums.CategoryType;

/**
 * 目录分类实体类
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:31:09
 */
public class FeatureCategoryInfo {
  private Long categoryId;

  private String categoryName;

  private CategoryType categoryType;

  private Date categoryCreateTime;

  private Date categoryModifyTime;

  private Boolean categoryValid;

  @Override
  public String toString() {
    return "FeatureCategoryInfo [categoryId="
        + categoryId
        + ", categoryName="
        + categoryName
        + ", categoryType="
        + categoryType
        + ", categoryCreateTime="
        + categoryCreateTime
        + ", categoryModifyTime="
        + categoryModifyTime
        + ", categoryValid="
        + categoryValid
        + "]";
  }

  public FeatureCategoryInfo(
      Long categoryId,
      String categoryName,
      CategoryType categoryType,
      Date categoryCreateTime,
      Date categoryModifyTime,
      Boolean categoryValid) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.categoryType = categoryType;
    this.categoryCreateTime = categoryCreateTime;
    this.categoryModifyTime = categoryModifyTime;
    this.categoryValid = categoryValid;
  }

  public FeatureCategoryInfo() {
    super();
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName == null ? null : categoryName.trim();
  }

  public CategoryType getCategoryType() {
    return categoryType;
  }

  public void setCategoryType(CategoryType categoryType) {
    this.categoryType = categoryType;
  }

  public Date getCategoryCreateTime() {
    return categoryCreateTime;
  }

  public void setCategoryCreateTime(Date categoryCreateTime) {
    this.categoryCreateTime = categoryCreateTime;
  }

  public Date getCategoryModifyTime() {
    return categoryModifyTime;
  }

  public void setCategoryModifyTime(Date categoryModifyTime) {
    this.categoryModifyTime = categoryModifyTime;
  }

  public Boolean getCategoryValid() {
    return categoryValid;
  }

  public void setCategoryValid(Boolean categoryValid) {
    this.categoryValid = categoryValid;
  }
}
