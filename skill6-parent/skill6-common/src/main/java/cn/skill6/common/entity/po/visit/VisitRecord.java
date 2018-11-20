package cn.skill6.common.entity.po.visit;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 访问记录实体类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月15日 下午11:38:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitRecord {

  private Long visitId;

  private Long userId;

  private Long visitContentId;

  private String visitContentType;

  private Date visitStartTime;

  private Date visitEndTime;
}
