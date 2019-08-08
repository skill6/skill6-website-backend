package cn.skill6.website.dao.impl.store;

import cn.skill6.common.entity.po.store.StoreImage;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.store.StoreImageDao;
import cn.skill6.website.dao.mappers.store.StoreImageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 图片上传信息操作实现类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月28日 上午12:18:22
 */
@Slf4j
@Repository
public class StoreImageDaoImpl implements StoreImageDao {

    @Autowired
    private StoreImageMapper storeImageMapper;

    @Override
    public int deleteByImageId(Long imageId) {
        log.warn("删除id为{}的图片信息", imageId);

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

        log.info("增加图片信息成功,{}", storeImage);

        return storeImage.getImageId();
    }

    @Override
    public StoreImage findByImageId(Long imageId) {
        StoreImage imageUpload = storeImageMapper.selectByPrimaryKey(imageId);

        log.info("找到id为{}的图片信息,{}", imageId, imageUpload);

        return imageUpload;
    }

    @Override
    public List<StoreImage> findAll() {
        List<StoreImage> storeImages = storeImageMapper.selectAll();
        log.info("找到所有图片存储记录,{}", storeImages);

        return storeImages;
    }

    @Override
    public void modifyByImageId(StoreImage storeImage) {
        if (storeImage.getImageId() == null) {
            throw new NullPointerException("图片存储id不能为null");
        }

        storeImageMapper.updateByPrimaryKey(storeImage);
        log.info("成功修改id为{}的图片存储记录,{}", storeImage.getImageId(), storeImage);
    }
}
