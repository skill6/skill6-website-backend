package cn.skill6.dashboard.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色权限关联实体类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月27日 下午11:20:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRolePermissionRel {

  private Long roleId;

  private Long permissionId;
}
