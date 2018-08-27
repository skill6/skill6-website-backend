package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.DiscussArea;
import cn.skill6.service.intf.basic.DiscussAreaOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:17:53
 */
public class DiscussAreaImpl implements DiscussAreaOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.DiscussAreaOper#deleteByDiscussId(java.lang.Long)
   */
  @Override
  public int deleteByDiscussId(Long discussId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.DiscussAreaOper#addDiscussArea(cn.skill6.common.entity.po.DiscussArea)
   */
  @Override
  public int addDiscussArea(DiscussArea discussArea) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.DiscussAreaOper#findByDiscussId(java.lang.Long)
   */
  @Override
  public DiscussArea findByDiscussId(Long discussId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.DiscussAreaOper#findAll()
   */
  @Override
  public List<DiscussArea> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.DiscussAreaOper#modifyByDiscussId(cn.skill6.common.entity.po.DiscussArea)
   */
  @Override
  public int modifyByDiscussId(DiscussArea discussArea) {
    // TODO Auto-generated method stub
    return 0;
  }
}
