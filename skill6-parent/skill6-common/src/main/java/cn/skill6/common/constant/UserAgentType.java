package cn.skill6.common.constant;

import lombok.Getter;

/**
 * 用户访问设备类型
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年12月30日 下午11:32:34
 */
public enum UserAgentType {
  PC("pc"),
  MOBILE("mobile");

  @Getter private String userAgent;

  private UserAgentType(String userAgent) {
    this.userAgent = userAgent;
  }
}
