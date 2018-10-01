package cn.skill6.common.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import cn.skill6.common.entity.enums.intf.BaseEnum;

/**
 * 实现Mybatis中状态枚举转换成状态码的通用处理类（数据库字段和Java枚举）
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月16日 上午12:01:07
 */
@SuppressWarnings("rawtypes")
public final class GeneralStateFieldHandler<E extends BaseEnum> extends BaseTypeHandler<E> {
  private Class<E> type;
  private E[] enums;

  /**
   * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
   *
   * @param type 配置文件中设置的转换类
   */
  public GeneralStateFieldHandler(Class<E> type) {
    if (type == null) {
      throw new IllegalArgumentException("Type argument cannot be null");
    }

    this.type = type;
    this.enums = type.getEnumConstants();

    if (this.enums == null) {
      throw new IllegalArgumentException(
          type.getSimpleName() + " does not represent an enum type.");
    }
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType)
      throws SQLException {
    // baseTypeHandler已经帮我们做了parameter的null判断
    if (jdbcType == null) {
      ps.setObject(i, parameter.getStateCode());
    } else {
      ps.setObject(i, parameter.getStateCode(), jdbcType.TYPE_CODE);
    }
  }

  @Override
  public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
    // 根据数据库存储类型决定获取类型,本例子中数据库中存放String类型
    String stateCode = rs.getString(columnName);

    if (rs.wasNull()) {
      return null;
    }

    return locateEnumStatus(stateCode);
  }

  @Override
  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    // 根据数据库存储类型决定获取类型,本例子中数据库中存放String类型
    String stateCode = rs.getString(columnIndex);

    if (rs.wasNull()) {
      return null;
    }

    return locateEnumStatus(stateCode);
  }

  @Override
  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
    String stateCode = cs.getString(columnIndex);

    if (cs.wasNull()) {
      return null;
    }

    return locateEnumStatus(stateCode);
  }

  /**
   * 根据数据库中的code值,定位EnumStatus子类
   *
   * @param stateCode 数据库中存储的自定义code属性
   * @return code对应的枚举类
   */
  private E locateEnumStatus(String stateCode) {
    for (E e : enums) {
      if (e.getStateCode().equals(stateCode)) {
        return e;
      }
    }

    throw new IllegalArgumentException("未知的枚举类型：" + stateCode + ",请核对" + type.getSimpleName());
  }
}
