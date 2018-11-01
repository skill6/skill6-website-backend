package cn.skill6.common.entity.po.other;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网站版本信息实体类
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:37:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionInfo {
  private Long versionId;

  private String versionUserId;

  private String versionNumber;

  private Date versionReleaseTime;

  private String versionContent;
}
