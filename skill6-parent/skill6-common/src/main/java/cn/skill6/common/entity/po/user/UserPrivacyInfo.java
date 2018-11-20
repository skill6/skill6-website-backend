package cn.skill6.common.entity.po.user;

import cn.skill6.common.entity.enums.UserState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户隐私信息实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:37:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivacyInfo {

  private Long userId;

  private String userName;

  private String userEmail;

  private String userPhone;

  private String userLoginFrom;

  private String userPassword;

  private String userPwdSalt;

  private String userType;

  private UserState userState;
}
