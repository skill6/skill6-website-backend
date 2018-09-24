package cn.skill6.website.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.store.StoreImage;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.service.basic.ImageUploadSvc;
import cn.skill6.website.config.Skill6Properties;
import cn.skill6.website.dao.intf.store.StoreImageOper;
import cn.skill6.website.util.storage.FileStoreHandler;

/**
 * 图片存储服务类
 *
 * @author 何明胜
 * @version 1.0.5
 * @since 2018年9月13日 上午12:45:47
 */
@Service
public class ImageUploadSvcImpl implements ImageUploadSvc {

  @Autowired
  @Qualifier("storeImageImpl")
  private StoreImageOper storeImageOper;

  @Autowired private FileStoreHandler fileStoreHandler;

  @Autowired private Skill6Properties skill6Properties;

  @Override
  public ResponseJson uploadImage(HttpServletRequest request)
      throws IOException, FileUploadException {
    String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
    String storeParentPath = skill6Properties.getImagePath() + dateFormat;

    StoreImage storeImage = new StoreImage();
    FileAttribute fileAttribute = fileStoreHandler.fileUploadHandler(request, storeParentPath);

    storeImage.setImageId(Long.valueOf(fileAttribute.getId()));
    storeImage.setImageName(fileAttribute.getName());
    storeImage.setImageUrl(fileAttribute.getUrl());
    storeImage.setImageHashCode(fileAttribute.getHashCode());

    storeImageOper.addImageUpload(storeImage);

    Map<String, String> resultMap = new HashMap<String, String>(5);
    resultMap.put("information", "上传成功");

    StringBuffer contextUrl = RequestParser.parseContextIndex(request);
    String imageUrl =
        contextUrl
            .append("/image/")
            .append(dateFormat)
            .append("/")
            .append(storeImage.getImageId())
            .toString();
    resultMap.put("image_url", imageUrl);

    return new ResponseJson(true, resultMap);
  }

  @Override
  public void downloadImageById(Long imageId, HttpServletResponse response) throws IOException {
    StoreImage storeImage = storeImageOper.findByImageId(imageId);

    String imageUrl = storeImage.getImageUrl();
    String imageName = storeImage.getImageName();

    fileStoreHandler.fileDownloadHandler(response, imageUrl, imageName);
  }
}
