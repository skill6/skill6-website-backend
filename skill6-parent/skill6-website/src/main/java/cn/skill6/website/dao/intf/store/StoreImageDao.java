package cn.skill6.website.dao.intf.store;

import java.util.List;

import cn.skill6.common.entity.po.store.StoreImage;

/**
 * 图片上传操作接口
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月24日 上午12:28:52
 */
public interface StoreImageDao {
  int deleteByImageId(Long imageId);

  Long addImageUpload(StoreImage storeImage);

  StoreImage findByImageId(Long imageId);

  List<StoreImage> findAll();

  int modifyByImageId(StoreImage storeImage);
}
