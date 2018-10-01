package cn.skill6.dashboard.dao.mappers;

import cn.skill6.dashboard.model.po.SysUserRoleRel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 系统用户-角色关联操作接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月27日 下午11:19:23
 */
public interface SysUserRoleRelMapper {
  int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

  int insert(SysUserRoleRel sysUserRoleRel);

  List<SysUserRoleRel> selectAll();
}
