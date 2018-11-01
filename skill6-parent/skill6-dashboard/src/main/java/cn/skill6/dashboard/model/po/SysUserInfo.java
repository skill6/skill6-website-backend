package cn.skill6.dashboard.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户信息实体类
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月27日 下午11:20:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserInfo {

  private Long userId;

  private String userName;

  private String userEmail;

  private String userPhone;

  private String userLoginFrom;

  private String userPassword;

  private String userPwdSalt;

  private String userType;

  private String userState;
}
