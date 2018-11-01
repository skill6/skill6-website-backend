package cn.skill6.dashboard.model.po;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色信息实体类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月27日 下午11:20:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleInfo {

  private Long roleId;

  private String roleName;

  private String roleCode;

  private String roleDesc;

  private Date roleCreateTime;

  private Date roleLastModifyTime;

  private Boolean roleValid;
}
