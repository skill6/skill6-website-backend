package cn.skill6.common.entity.po.abst;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.skill6.common.entity.enums.SortType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页和排序作为数据库实体类的父类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年9月21日 下午10:31:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PaginationAndSort {

  /** 从1开始 */
  private int pageNum = 1;

  private int pageSize = 10;

  private String orderBy;
  @JsonIgnore private SortType sortType = SortType.ASCENDING;
}
