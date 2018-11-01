package cn.skill6.common.entity.po.rbac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RBAC用户角色关联
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年9月23日 下午5:53:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacUserRoleRel {

  private Long userId;

  private Long roleId;
}
