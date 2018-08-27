package cn.skill6.website.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.skill6.common.entity.po.ImageUpload;
import cn.skill6.service.intf.basic.ImageUploadOper;
import cn.skill6.website.dao.ImageUploadMapper;

/**
 * 图片上传信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:18:22
 */
public class ImageUploadImpl implements ImageUploadOper {
  private static final Logger logger = LoggerFactory.getLogger(ImageUploadImpl.class);

  @Autowired private ImageUploadMapper imageUploadMapper;

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ImageUploadOper#deleteByImageId(java.lang.Long)
   */
  @Override
  public int deleteByImageId(Long imageId) {
    logger.warn("删除id为{}的图片信息", imageId);

    return imageUploadMapper.deleteByPrimaryKey(imageId);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ImageUploadOper#addImageUpload(cn.skill6.common.entity.po.ImageUpload)
   */
  @Override
  public int addImageUpload(ImageUpload imageUpload) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ImageUploadOper#findByImageId(java.lang.Long)
   */
  @Override
  public ImageUpload findByImageId(Long imageId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ImageUploadOper#findAll()
   */
  @Override
  public List<ImageUpload> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ImageUploadOper#modifyByImageId(cn.skill6.common.entity.po.ImageUpload)
   */
  @Override
  public int modifyByImageId(ImageUpload imageUpload) {
    // TODO Auto-generated method stub
    return 0;
  }
}
