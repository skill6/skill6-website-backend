package cn.skill6.common.entity.po.base;

import cn.skill6.common.entity.enums.SortType;

/**
 * 分页父类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月21日 下午10:31:26
 */
public abstract class Pagination {
  private String orderBy;
  private SortType sortType;

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */ @Override
  public String toString() {
    return "Pagination [orderBy=" + orderBy + ", sortType=" + sortType + "]";
  }

  /** @return the orderBy */
  public String getOrderBy() {
    return orderBy;
  }

  /** @param orderBy the orderBy to set */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  /** @return the sortType */
  public String getSortType() {
    return sortType.getStateCode();
  }

  /** @param sortType the sortType to set */
  public void setSortType(SortType sortType) {
    this.sortType = sortType;
  }
}
