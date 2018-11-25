package cn.skill6.common.entity.po.thirdparty;

import java.util.Date;

import cn.skill6.common.entity.po.abst.PaginationAndSort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 第三方授权实体类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 下午11:29:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ThirdpartyAuth extends PaginationAndSort {

  private Long thirdpartyId;

  private Long userId;

  private String thirdpartyPrimaryKey;

  private Boolean thirdpartyValid;

  private Date thirdpartyCreateTime;

  private String thirdpartyData;
}
