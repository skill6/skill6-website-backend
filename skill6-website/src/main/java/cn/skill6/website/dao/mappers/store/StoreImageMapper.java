package cn.skill6.website.dao.mappers.store;

import cn.skill6.common.entity.po.store.StoreImage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图片存储mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:40:37
 */
@Repository
public interface StoreImageMapper {
    int deleteByPrimaryKey(Long imageId);

    int insert(StoreImage storeImage);

    StoreImage selectByPrimaryKey(Long imageId);

    List<StoreImage> selectAll();

    int updateByPrimaryKey(StoreImage storeImage);
}
