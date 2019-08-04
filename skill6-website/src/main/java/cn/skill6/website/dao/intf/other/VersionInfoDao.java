package cn.skill6.website.dao.intf.other;

import cn.skill6.common.entity.po.other.VersionInfo;

import java.util.List;

/**
 * 版本信息操作接口
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月24日 上午12:31:10
 */
public interface VersionInfoDao {
    int deleteByVersionId(Long versionId);

    void addVersionInfo(VersionInfo versionInfo);

    VersionInfo findByVersionId(Long versionId);

    List<VersionInfo> findAll();

    void modifyByVersionId(VersionInfo versionInfo);
}
