package cn.skill6.common.entity.enums.intf;

/**
 * 数据库状态字段枚举基类
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年4月27日 下午2:59:35
 */
public interface BaseEnum<E extends Enum<?>, T> {
  /**
   * 与枚举名称相同的小写字母
   *
   * @return 状态码
   */
  T getStateCode();

  /** @return 枚举的描述 */
  String getDescrition();
}
