package cn.skill6.website.dao.mappers.store;

import cn.skill6.common.entity.po.store.StoreFile;

import java.util.List;

/**
 * 文件存储mapper
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:40:27
 */
public interface StoreFileMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(StoreFile storeFile);

    StoreFile selectByPrimaryKey(Long fileId);

    List<StoreFile> selectAll();

    int updateByPrimaryKey(StoreFile storeFile);
}
