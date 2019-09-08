package cn.skill6.website.dao.mappers.basic;

import cn.skill6.common.entity.po.other.VersionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 版本信息mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:41:56
 */
@Repository
public interface VersionInfoMapper {
    int deleteByPrimaryKey(Long versionId);

    int insert(VersionInfo versionInfo);

    VersionInfo selectByPrimaryKey(Long versionId);

    List<VersionInfo> selectAll();

    int updateByPrimaryKey(VersionInfo versionInfo);
}
