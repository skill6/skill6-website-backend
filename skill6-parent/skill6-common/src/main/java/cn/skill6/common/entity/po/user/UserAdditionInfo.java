package cn.skill6.common.entity.po.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:36:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdditionInfo {

  private Long userId;

  private String userNickName;

  private Date userRegisterTime;

  private String userHeadUrl;

  private Boolean userSex;

  private String userBirthday;

  private Boolean userBirthdayType;

  private String userDesc;

  private Date userLastLoginTime;
}
