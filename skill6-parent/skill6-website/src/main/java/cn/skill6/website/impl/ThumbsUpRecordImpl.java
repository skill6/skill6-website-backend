package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.ThumbsUpRecord;
import cn.skill6.service.intf.basic.ThumbsUpRecordOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:19:05
 */
public class ThumbsUpRecordImpl implements ThumbsUpRecordOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ThumbsUpRecordOper#deleteByPrimaryKey(java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public int deleteByPrimaryKey(String userId, String articleId, String thumbsUpType) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ThumbsUpRecordOper#addThumbsUpRecord(cn.skill6.common.entity.po.ThumbsUpRecord)
   */
  @Override
  public int addThumbsUpRecord(ThumbsUpRecord record) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ThumbsUpRecordOper#findByPrimaryKey(java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public ThumbsUpRecord findByPrimaryKey(String userId, String articleId, String thumbsUpType) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ThumbsUpRecordOper#findAll()
   */
  @Override
  public List<ThumbsUpRecord> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ThumbsUpRecordOper#modifyByPrimaryKey(cn.skill6.common.entity.po.ThumbsUpRecord)
   */
  @Override
  public int modifyByPrimaryKey(ThumbsUpRecord record) {
    // TODO Auto-generated method stub
    return 0;
  }
}
