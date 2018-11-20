package cn.skill6.common.entity.po.feature;

import java.util.Date;

import cn.skill6.common.entity.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目录分类实体类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月15日 下午11:31:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureCategoryInfo {

  private Long categoryId;

  private String categoryName;

  private CategoryType categoryType;

  private Date categoryCreateTime;

  private Date categoryUpdateTime;

  private Boolean categoryValid;
}
