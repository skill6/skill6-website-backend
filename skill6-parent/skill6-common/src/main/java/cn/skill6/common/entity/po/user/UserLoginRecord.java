package cn.skill6.common.entity.po.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录记录实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:35:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRecord {

  private Long loginId;

  private Long userId;

  private String loginIp;

  private String loginType;

  private String loginEquipment;

  private Date loginTime;

  private Boolean loginResult;

  private String loginFailReason;
}
