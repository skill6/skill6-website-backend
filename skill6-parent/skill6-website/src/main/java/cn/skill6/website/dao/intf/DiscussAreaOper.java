package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.DiscussArea;

/**
 * 讨论区操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:28:17
 */
public interface DiscussAreaOper {
  int deleteByDiscussId(Long discussId);

  int addDiscussArea(DiscussArea discussArea);

  DiscussArea findByDiscussId(Long discussId);

  List<DiscussArea> findAll();

  int modifyByDiscussId(DiscussArea discussArea);
}
