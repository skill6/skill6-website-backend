package cn.skill6.service.intf.basic;

import java.util.List;

import cn.skill6.common.entity.po.ImageUpload;

/**
 * 图片上传操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:28:52
 */
public interface ImageUploadOper {
  int deleteByImageId(Long imageId);

  int addImageUpload(ImageUpload imageUpload);

  ImageUpload findByImageId(Long imageId);

  List<ImageUpload> findAll();

  int modifyByImageId(ImageUpload imageUpload);
}
