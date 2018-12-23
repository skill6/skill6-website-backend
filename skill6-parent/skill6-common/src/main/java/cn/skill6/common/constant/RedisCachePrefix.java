package cn.skill6.common.constant;

/**
 * redis缓存前缀=模块@功能@详情: /模块(功能)@详情: <br>
 * 如shiro@login@auth_code: /register@auth_code:
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年3月30日 下午1:12:46
 */
public class RedisCachePrefix {

  /** mybatis缓存 */
  public static final String MYBATIS_REDIS_CACHE = "mybatis@redis_cache:";

  /** 注册验证码缓存 */
  public static final String REGISTER_REDIS_CODE = "register@auth_code:";

  /** shiro缓存 */
  public static final String SHIRO_REDIS_CACHE = "shiro@redis_cache:";

  /** 客户配置shiro会话缓存 */
  public static final String SHIRO_REDIS_SESSION = "shiro@session@cache:";

  /** 登录失败次数限制缓存 */
  public static final String SHIRO_LOGIN_FAIL_COUNT = "shiro@login@fail_count:";

  /** shiro 登录失败最大次数 */
  public static final int SHIRO_LOGIN_FAIL_MAX_COUNT = 5;
}
