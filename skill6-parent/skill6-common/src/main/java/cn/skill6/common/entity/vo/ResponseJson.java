package cn.skill6.common.entity.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * RESTful 返回json
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年3月21日 下午3:52:46
 */
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResponseJson implements Serializable {
  private static final long serialVersionUID = 1L;

  /** 不使用封装,默认为false */
  private Boolean success;

  private Object message;

  public ResponseJson() {}

  /**
   * 只有结果
   *
   * @param success
   */
  public ResponseJson(Boolean success) {
    super();
    this.success = success;
  }
}
