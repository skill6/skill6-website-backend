package cn.skill6.website.dao;

import cn.skill6.common.entity.po.VersionInfo;
import java.util.List;

/**
 * 版本信息mapper
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月15日 下午11:41:56
 */
public interface VersionInfoMapper {
  int deleteByPrimaryKey(String versionId);

  int insert(VersionInfo record);

  VersionInfo selectByPrimaryKey(String versionId);

  List<VersionInfo> selectAll();

  int updateByPrimaryKey(VersionInfo record);
}
