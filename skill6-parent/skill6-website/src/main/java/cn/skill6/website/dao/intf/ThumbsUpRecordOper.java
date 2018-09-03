package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.ThumbsUpRecord;

/**
 * 点赞操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:29:55
 */
public interface ThumbsUpRecordOper {
  int deleteByPrimaryKey(String userId, String articleId, String thumbsUpType);

  int addThumbsUpRecord(ThumbsUpRecord record);

  ThumbsUpRecord findByPrimaryKey(String userId, String articleId, String thumbsUpType);

  List<ThumbsUpRecord> findAll();

  int modifyByPrimaryKey(ThumbsUpRecord record);
}
