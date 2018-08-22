package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ThumbsUpRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 点赞记录mapper
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:41:09
 */
public interface ThumbsUpRecordMapper {
  int deleteByPrimaryKey(
      @Param("userId") String userId,
      @Param("articleId") String articleId,
      @Param("thumbsUpType") String thumbsUpType);

  int insert(ThumbsUpRecord record);

  ThumbsUpRecord selectByPrimaryKey(
      @Param("userId") String userId,
      @Param("articleId") String articleId,
      @Param("thumbsUpType") String thumbsUpType);

  List<ThumbsUpRecord> selectAll();

  int updateByPrimaryKey(ThumbsUpRecord record);
}
