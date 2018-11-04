package cn.skill6.common.entity.po.feature;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 讨论区实体类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月15日 下午11:32:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDiscussArea {

  private Long discussId;

  private Long userId;

  private Long discussBelongId;

  private Long discussParentId;

  private Date discussCreateTime;

  private Boolean discussValid;

  private String discussContent;
}
