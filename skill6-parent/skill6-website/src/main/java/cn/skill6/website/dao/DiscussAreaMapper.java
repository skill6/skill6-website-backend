package cn.skill6.website.dao;

import cn.skill6.common.entity.po.DiscussArea;
import java.util.List;

/**
 * 讨论区mapper
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:40:09
 */
public interface DiscussAreaMapper {
  int deleteByPrimaryKey(Long discussId);

  int insert(DiscussArea record);

  DiscussArea selectByPrimaryKey(Long discussId);

  List<DiscussArea> selectAll();

  int updateByPrimaryKey(DiscussArea record);
}
