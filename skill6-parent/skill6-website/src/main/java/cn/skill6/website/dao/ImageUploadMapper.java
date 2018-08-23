package cn.skill6.website.dao;

import cn.skill6.common.entity.po.ImageUpload;
import java.util.List;

/**
 * 图片上传mapper
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年8月15日 下午11:40:37
 */
public interface ImageUploadMapper {
  int deleteByPrimaryKey(Long imageId);

  int insert(ImageUpload imageUpload);

  ImageUpload selectByPrimaryKey(Long imageId);

  List<ImageUpload> selectAll();

  int updateByPrimaryKey(ImageUpload imageUpload);
}
