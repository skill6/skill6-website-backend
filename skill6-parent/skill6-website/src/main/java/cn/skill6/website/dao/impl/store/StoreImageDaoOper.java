package cn.skill6.website.dao.impl.store;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.skill6.common.entity.po.store.StoreImage;
import cn.skill6.common.exception.db.NullPointerException;
import cn.skill6.website.dao.intf.store.StoreImageDao;
import cn.skill6.website.dao.mappers.store.StoreImageMapper;

/**
 * 图片上传信息操作实现类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月28日 上午12:18:22
 */
@Repository
public class StoreImageDaoOper implements StoreImageDao {
  private static final Logger logger = LoggerFactory.getLogger(StoreImageDaoOper.class);

  @Autowired private StoreImageMapper storeImageMapper;

  @Override
  public int deleteByImageId(Long imageId) {
    logger.warn("删除id为{}的图片信息", imageId);

    return storeImageMapper.deleteByPrimaryKey(imageId);
  }

  @Override
  public Long addImageUpload(StoreImage storeImage) {
    if (storeImage == null || storeImage.getImageId() == null) {
      throw new NullPointerException("图片内容或者图片id为空");
    }

    storeImage.setImageUploadTime(new Date());
    storeImage.setImageDownloadCount(0);
    storeImage.setImageType("123");

    storeImageMapper.insert(storeImage);

    logger.info("增加图片信息成功,{}", storeImage);

    return storeImage.getImageId();
  }

  @Override
  public StoreImage findByImageId(Long imageId) {
    StoreImage imageUpload = storeImageMapper.selectByPrimaryKey(imageId);

    logger.info("找到id为{}的图片信息,{}", imageId, imageUpload);

    return imageUpload;
  }

  @Override
  public List<StoreImage> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int modifyByImageId(StoreImage storeImage) {
    // TODO Auto-generated method stub
    return 0;
  }
}
