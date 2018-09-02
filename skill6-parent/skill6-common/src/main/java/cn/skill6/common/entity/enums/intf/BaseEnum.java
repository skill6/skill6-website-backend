package cn.skill6.common.entity.enums.intf;

/**
 * 数据库状态字段枚举基类
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年4月27日 下午2:59:35
 */
public interface BaseEnum<E extends Enum<?>, T> {
  /**
   * 状态码
   *
   * @return
   */
  public T getStateCode();

  /**
   * 状态描述
   *
   * @return
   */
  public String getDescrition();
}
