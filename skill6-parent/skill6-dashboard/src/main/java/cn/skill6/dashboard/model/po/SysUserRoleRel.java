package cn.skill6.dashboard.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户-角色关联实体类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月27日 下午11:20:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRoleRel {

  private Long userId;

  private Long roleId;
}
