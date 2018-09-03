package cn.skill6.website.dao.intf;

import java.util.List;

import cn.skill6.common.entity.po.VersionInfo;

/**
 * 版本信息操作接口
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年8月24日 上午12:31:10
 */
public interface VersionInfoOper {
  int deleteByVersionId(String versionId);

  int addVersionInfo(VersionInfo versionInfo);

  VersionInfo findByVersionId(String versionId);

  List<VersionInfo> findAll();

  int modifyByVersionId(VersionInfo versionInfo);
}
