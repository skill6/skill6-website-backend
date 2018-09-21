package cn.skill6.website.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.skill6.website.config.Skill6Properties;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.ImageUpload;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.service.basic.ImageUploadSvc;
import cn.skill6.website.constant.Constant;
import cn.skill6.website.dao.intf.ImageUploadOper;
import cn.skill6.website.util.storage.FileStoreHandler;

/**
 * 图片存储服务类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月13日 上午12:45:47
 */
@Service
public class ImageUploadSvcImpl implements ImageUploadSvc {

  @Autowired
  @Qualifier("imageUploadImpl")
  private ImageUploadOper imageUploadOper;

  @Autowired private FileStoreHandler fileStoreHandler;

  @Autowired private Skill6Properties skill6Properties;

  /* (non-Javadoc)
   * @see cn.skill6.service.basic.ImageUploadSvc#uploadImage(javax.servlet.http.HttpServletRequest)
   */
  @Override
  public ResponseJson uploadImage(HttpServletRequest request)
      throws IOException, FileUploadException {
    String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
    String storeParentPath = skill6Properties.getImagePath() + dateFormat;

    ImageUpload imageUpload = new ImageUpload();
    FileAttribute fileAttribute = fileStoreHandler.fileUploadHandler(request, storeParentPath);

    imageUpload.setImageId(Long.valueOf(fileAttribute.getId()));
    imageUpload.setImageName(fileAttribute.getName());
    imageUpload.setImageUrl(fileAttribute.getUrl());
    imageUploadOper.addImageUpload(imageUpload);

    Map<String, String> resultMap = new HashMap<String, String>(5);
    resultMap.put("information", "上传成功");

    StringBuffer contextUrl = RequestParser.parseContextIndex(request);
    String imageUrl =
        contextUrl
            .append("/image/")
            .append(dateFormat)
            .append("/")
            .append(imageUpload.getImageId())
            .toString();
    resultMap.put("image_url", imageUrl);

    return new ResponseJson(true, resultMap);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.basic.ImageUploadSvc#downloadImageById(java.lang.Long, javax.servlet.http.HttpServletResponse)
   */
  @Override
  public void downloadImageById(Long imageId, HttpServletResponse response) throws IOException {
    ImageUpload imageUpload = imageUploadOper.findByImageId(imageId);

    String imageUrl = imageUpload.getImageUrl();
    String imageName = imageUpload.getImageName();

    fileStoreHandler.fileDownloadHandler(response, imageUrl, imageName);
  }
}
