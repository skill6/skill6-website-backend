package cn.skill6.website.dao.mappers.other;

import cn.skill6.common.entity.po.other.VersionInfo;
import java.util.List;

/**
 * 版本信息mapper
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年8月15日 下午11:41:56
 */
public interface VersionInfoMapper {
  int deleteByPrimaryKey(Long versionId);

  int insert(VersionInfo versionInfo);

  VersionInfo selectByPrimaryKey(Long versionId);

  List<VersionInfo> selectAll();

  int updateByPrimaryKey(VersionInfo versionInfo);
}
