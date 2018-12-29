package cn.skill6.microservice.sign;

/**
 * 登录服务
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月23日 下午10:22:12
 */
public interface SignInSvc {
  /**
   * 使用github登录
   *
   * @param authCode
   */
  void loginByGitHub(String authCode);

  /**
   * 使用QQ登录
   *
   * @param authCode
   */
  void loginByQq(String authCode);
}
