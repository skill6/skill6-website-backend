package cn.skill6.common.entity.po.base;

import cn.skill6.common.entity.enums.SortType;

/**
 * 分页和排序作为数据库实体类的父类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月21日 下午10:31:26
 */
public abstract class PaginationAndSort {
  private int pageNum;
  private int pageSize;

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
    return sortType == null ? null : sortType.getStateCode();
  }

  /** @param sortType the sortType to set */
  public void setSortType(SortType sortType) {
    this.sortType = sortType;
  }

  /** @return the pageNum */
  public int getPageNum() {
    return pageNum;
  }

  /** @param pageNum the pageNum to set */
  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  /** @return the pageSize */
  public int getPageSize() {
    return pageSize;
  }

  /** @param pageSize the pageSize to set */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
}
