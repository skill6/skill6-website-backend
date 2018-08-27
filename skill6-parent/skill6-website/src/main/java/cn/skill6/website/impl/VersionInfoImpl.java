package cn.skill6.website.impl;

import java.util.List;

import cn.skill6.common.entity.po.VersionInfo;
import cn.skill6.service.intf.basic.VersionInfoOper;

/**
 * TODO
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年8月28日 上午12:20:18
 */
public class VersionInfoImpl implements VersionInfoOper {

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VersionInfoOper#deleteByVersionId(java.lang.String)
   */
  @Override
  public int deleteByVersionId(String versionId) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VersionInfoOper#addVersionInfo(cn.skill6.common.entity.po.VersionInfo)
   */
  @Override
  public int addVersionInfo(VersionInfo versionInfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VersionInfoOper#findByVersionId(java.lang.String)
   */
  @Override
  public VersionInfo findByVersionId(String versionId) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VersionInfoOper#findAll()
   */
  @Override
  public List<VersionInfo> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.intf.basic.VersionInfoOper#modifyByVersionId(cn.skill6.common.entity.po.VersionInfo)
   */
  @Override
  public int modifyByVersionId(VersionInfo versionInfo) {
    // TODO Auto-generated method stub
    return 0;
  }
}
