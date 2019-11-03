package cn.skill6.website.dao.intf.basic;

import cn.skill6.common.entity.po.other.VersionInfo;
import cn.skill6.common.entity.vo.PageResult;

import java.util.List;

/**
 * 版本信息操作接口
 *
 * @author 何明胜
 * @since 2018年8月24日 上午12:31:10
 */
public interface VersionDao {
    int deleteByVersionId(Long versionId);

    void addVersionInfo(VersionInfo versionInfo);

    VersionInfo findByVersionId(Long versionId);

    List<VersionInfo> findAll();

    void modifyByVersionId(VersionInfo versionInfo);

    PageResult<VersionInfo> getVersionByPage(int pageSize, int pageNum);
}
