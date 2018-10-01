package cn.skill6.common.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过反射获取实体类的属性、方法等
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年9月22日 下午11:09:01
 */
public class ReflectEnity {
  /**
   * 返回当前类的所有属性
   *
   * @param clazz
   * @return 属性数组
   */
  public static List<Field> getCurrentFields(Class<?> clazz) {
    Field[] fields = clazz.getDeclaredFields();

    return Arrays.asList(fields);
  }

  /**
   * 获取一个类及其父类的所有属性
   *
   * @param clazz
   * @return 属性数组
   */
  public static List<Field> getAllFields(Class<?> clazz) {
    final List<Field> allFields = new ArrayList<Field>();

    Class<?> currentClass = clazz;
    while (currentClass != null) {
      final Field[] declaredFields = currentClass.getDeclaredFields();
      for (final Field field : declaredFields) {
        allFields.add(field);
      }
      currentClass = currentClass.getSuperclass();
    }

    return allFields;
  }

  /**
   * 通过反射判断一个字符串是否是某个实体类的属性，目前主要针对String类型，与数据库对应
   *
   * @param aimFieldName 泛型参数
   * @return 判断结果
   */
  public static boolean judgeFieldIsExist(Class<?> clazz, String aimFieldName) {
    List<Field> fields = getAllFields(clazz);

    for (Field field : fields) {
      String fieldName = field.getName();
      if (fieldName.equals(aimFieldName)) {
        return true;
      }
    }

    return false;
  }
}
