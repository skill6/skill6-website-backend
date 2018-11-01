package cn.skill6.common.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件属性
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月13日 上午2:25:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileAttribute {

  String id;
  String name;
  String suffix;
  String url;
  String hashCode;
}
