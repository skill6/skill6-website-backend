package cn.skill6.website.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ThumbsUpRecord;
import cn.skill6.website.dao.ThumbsUpRecordMapper;
import cn.skill6.website.dao.intf.ThumbsUpRecordOper;

/**
 * 点赞记录操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:19:05
 */
public class ThumbsUpRecordImpl implements ThumbsUpRecordOper {
  private static final Logger logger = LoggerFactory.getLogger(ThumbsUpRecordImpl.class);

  @Autowired private ThumbsUpRecordMapper thumbsUpRecordMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ThumbsUpRecordOper#deleteByPrimaryKey(java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public int deleteByPrimaryKey(String userId, String articleId, String thumbsUpType) {
    logger.warn("删除用户id为{},文章id为{},类型为{}的点赞记录", userId, articleId);

    return thumbsUpRecordMapper.deleteByPrimaryKey(userId, articleId, thumbsUpType);
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
