package cn.skill6.website.dao.mappers.store;

import cn.skill6.common.entity.po.store.StoreImage;
import java.util.List;

/**
 * 图片存储mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:40:37
 */
public interface StoreImageMapper {
  int deleteByPrimaryKey(Long imageId);

  int insert(StoreImage storeImage);

  StoreImage selectByPrimaryKey(Long imageId);

  List<StoreImage> selectAll();

  int updateByPrimaryKey(StoreImage storeImage);
}
