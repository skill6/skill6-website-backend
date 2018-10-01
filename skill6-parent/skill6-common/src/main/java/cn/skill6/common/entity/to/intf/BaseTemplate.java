package cn.skill6.common.entity.to.intf;

import cn.skill6.common.utility.ReflectEnity;

/**
 * 模板类的基类
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月22日 下午11:37:03
 */
public interface BaseTemplate {
  boolean judgeFieldIsExist(String aimFieldName);

  default boolean judgeFieldIsExist(Class<?> clazz, String aimFieldName) {
    return ReflectEnity.judgeFieldIsExist(clazz, aimFieldName);
  }
}
