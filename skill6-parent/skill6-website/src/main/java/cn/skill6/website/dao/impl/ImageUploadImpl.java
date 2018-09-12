package cn.skill6.website.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.skill6.common.entity.po.ImageUpload;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.website.dao.ImageUploadMapper;
import cn.skill6.website.dao.intf.ImageUploadOper;

/**
 * 图片上传信息操作实现类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月28日 上午12:18:22
 */
@Repository
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
  public Long addImageUpload(ImageUpload imageUpload) {
    if (imageUpload == null || imageUpload.getImageId() == null) {
      throw new NullPointerException("图片内容或者图片id为空");
    }

    imageUpload.setImageUploadDate(new Date());
    imageUpload.setImageDownloadCount(0);
    imageUpload.setImageType("123");
    
    imageUploadMapper.insert(imageUpload);

    logger.info("增加图片信息成功,{}", imageUpload);

    return imageUpload.getImageId();
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.ImageUploadOper#findByImageId(java.lang.Long)
   */
  @Override
  public ImageUpload findByImageId(Long imageId) {
    ImageUpload imageUpload = imageUploadMapper.selectByPrimaryKey(imageId);

    logger.info("找到id为{}的图片信息,{}", imageId, imageUpload);

    return imageUpload;
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
