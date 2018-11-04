package cn.skill6.dashboard.model.po;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统权限实体类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年9月27日 下午11:20:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysPermissionInfo {

  private Long permissionId;

  private String permissionName;

  private String permissionCode;

  private String permissionDesc;

  private Boolean permissionNavi;

  private String permissionUrl;

  private Date permissionCreateTime;

  private Date permissionUpdateTime;

  private Boolean permissionValid;
}
