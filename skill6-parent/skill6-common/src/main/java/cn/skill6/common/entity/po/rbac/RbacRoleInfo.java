package cn.skill6.common.entity.po.rbac;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RBAC角色信息
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年9月23日 下午5:52:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacRoleInfo {

  private Long roleId;

  private String roleName;

  private String roleCode;

  private String roleDesc;

  private Date roleCreateTime;

  private Date roleUpdateTime;

  private Boolean roleValid;
}
