package cn.skill6.dashboard.dao.mappers;

import cn.skill6.dashboard.model.po.SysRoleInfo;
import java.util.List;

/**
 * 系统角色信息操作接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月27日 下午11:18:13
 */
public interface SysRoleInfoMapper {
  int deleteByPrimaryKey(Long roleId);

  int insert(SysRoleInfo sysRoleInfo);

  SysRoleInfo selectByPrimaryKey(Long roleId);

  List<SysRoleInfo> selectAll();

  int updateByPrimaryKey(SysRoleInfo sysRoleInfo);
}
