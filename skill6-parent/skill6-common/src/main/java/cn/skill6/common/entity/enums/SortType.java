package cn.skill6.common.entity.enums;

import cn.skill6.common.entity.enums.intf.BaseEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 排序枚举
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月21日 下午10:34:15
 */
public enum SortType implements BaseEnum<Enum<SortType>, String> {
  ASCENDING("ASC", "升序排列"),
  DESCENDING("DESC", "降序排列");

  private String stateCode;
  private String description;

  /**
   * @param stateCode
   * @param description
   */
  private SortType(String stateCode, String description) {
    this.stateCode = stateCode;
    this.description = description;
  }

  /* (non-Javadoc)
   * @see cn.skill6.common.entity.enums.intf.BaseEnum#getStateCode()
   */
  @Override
  public String getStateCode() {
    return stateCode;
  }

  /* (non-Javadoc)
   * @see cn.skill6.common.entity.enums.intf.BaseEnum#getDescrition()
   */
  @Override
  public String getDescrition() {
    return description;
  }

  /** @return the description */
  public String getDescription() {
    return description;
  }

  /** @param description the description to set */
  public void setDescription(String description) {
    this.description = description;
  }

  /** @param stateCode the stateCode to set */
  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  /** 将枚举值的code写入json */
  public static class SortTypeJsonSerializer extends JsonSerializer<SortType> {
    @Override
    public void serialize(
        SortType sortType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
        throws IOException {
      jsonGenerator.writeString(sortType.stateCode);
    }
  }

  /** 依据code值获取对应枚举 */
  public static class SortTypeJsonDeserializer extends JsonDeserializer<SortType> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortTypeJsonDeserializer.class);

    @Override
    public SortType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      String code = p.getText();
      for (SortType type : SortType.values()) {
        if (type.stateCode.equalsIgnoreCase(code)) {
          return type;
        }
      }
      LOGGER.warn("解析 SortType enum 失败,{} -> {}", code, null);
      return null;
    }
  }
}
