package cn.skill6.common.entity.po.store;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片上传实体类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月15日 下午11:35:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreImage {

  private Long imageId;

  private String imageName;

  private String imageUrl;

  private Date imageUploadTime;

  private String imageType;

  private String imageHashCode;

  private Integer imageDownloadCount;
}
