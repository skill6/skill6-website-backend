package cn.skill6.common.entity.po.feature;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点赞记录实体类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月15日 下午11:36:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureThumbsUpRecord {

  private Long userId;

  private Long articleId;

  private String thumbsUpType;

  private Date thumbsUpTime;
}
