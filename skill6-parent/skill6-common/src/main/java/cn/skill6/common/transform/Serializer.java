package cn.skill6.common.transform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.skill6.common.BaseUtils;
import cn.skill6.common.exception.tools.StackTrace2Str;
import lombok.extern.slf4j.Slf4j;

/**
 * 序列化转换器
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年4月1日 下午10:07:26
 */
@Slf4j
public class Serializer extends BaseUtils {

  /**
   * 序列化对象
   *
   * @param object
   * @return 字节数组
   */
  public static byte[] serialize(Object object) {
    if (object == null) {
      return null;
    }

    if (!(object instanceof Serializable)) {
      throw new IllegalArgumentException(
          Serializer.class.getSimpleName()
              + " requires a Serializable payload "
              + "but received an object of type ["
              + object.getClass().getName()
              + "]");
    }

    ObjectOutputStream objectOutputStream = null;
    ByteArrayOutputStream byteArrayOutputStream = null;

    try {
      byteArrayOutputStream = new ByteArrayOutputStream();
      objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      objectOutputStream.writeObject(object);
      objectOutputStream.flush();
      byte[] byteArray = byteArrayOutputStream.toByteArray();

      log.trace("序列化成功, 结果字节数组长度={}", byteArray.length);

      return byteArray;
    } catch (IOException e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("序列化失败", e));
    }

    return null;
  }

  /**
   * 反序列化成对象
   *
   * @param byteArray
   * @return 对象
   */
  public static Object unserialize(byte[] byteArray) {
    if (isEmpty(byteArray)) {
      return null;
    }

    ObjectInputStream objectInputStream = null;
    ByteArrayInputStream byteArrayInputStream = null;

    try {
      byteArrayInputStream = new ByteArrayInputStream(byteArray);
      objectInputStream = new ObjectInputStream(byteArrayInputStream);
      Object object = objectInputStream.readObject();

      log.trace("反序列化成功, 结果为：{}", object.toString());

      return object;
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("反序列化失败", e));
    }

    return null;
  }

  /**
   * 序列化 list 集合
   *
   * @param list
   */
  public static byte[] serializeList(List<Object> list) {
    if (list.isEmpty()) {
      return null;
    }
    ObjectOutputStream oos = null;
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(baos);
      for (Object obj : list) {
        oos.writeObject(obj);
      }
      byteArray = baos.toByteArray();
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("序列化失败", e));
    }

    log.trace("序列化成功, 结果字节数组长度={}", byteArray.length);

    return byteArray;
  }

  /**
   * 反序列化 list 集合
   *
   * @param bytes
   */
  public static List<Object> unserializeList(byte[] bytes) {
    if (bytes == null) {
      return null;
    }

    List<Object> list = new ArrayList<Object>();
    ByteArrayInputStream bais = null;
    ObjectInputStream ois = null;
    try {
      // 反序列化
      bais = new ByteArrayInputStream(bytes);
      ois = new ObjectInputStream(bais);
      while (bais.available() > 0) {
        Object obj = (Object) ois.readObject();
        if (obj == null) {
          break;
        }
        list.add(obj);
      }
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("反序列化List<Object>失败", e));
    }

    log.trace("反序列化成功, 结果为：{}", list.toString());

    return list;
  }

  /**
   * 序列化 set 集合
   *
   * @param set
   */
  public static byte[] serializeSet(Set<Object> set) {
    if (set.isEmpty()) {
      return null;
    }
    ObjectOutputStream oos = null;
    ByteArrayOutputStream baos = null;
    byte[] byteArray = null;
    try {
      baos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(baos);
      for (Object obj : set) {
        oos.writeObject(obj);
      }
      byteArray = baos.toByteArray();
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("序列化失败", e));
    }

    log.trace("序列化成功, 结果字节数组长度={}", byteArray.length);

    return byteArray;
  }

  /**
   * 反序列化 set 集合
   *
   * @param bytes
   */
  public static Set<Object> unserializeSet(byte[] bytes) {
    if (bytes == null) {
      return null;
    }

    Set<Object> set = new HashSet<Object>();
    ByteArrayInputStream bais = null;
    ObjectInputStream ois = null;
    try {
      // 反序列化
      bais = new ByteArrayInputStream(bytes);
      ois = new ObjectInputStream(bais);
      while (bais.available() > 0) {
        Object obj = (Object) ois.readObject();
        if (obj == null) {
          break;
        }
        set.add(obj);
      }
    } catch (Exception e) {
      log.error(StackTrace2Str.exceptionStackTrace2Str("反序列化Set<Object>失败", e));
    }

    log.trace("反序列化成功, 结果为：{}", set.toString());

    return set;
  }
}
