package cn.skill6.website.service.basic.store;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.store.StoreImage;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.microservice.basic.store.StoreImageSvc;
import cn.skill6.website.config.Skill6Properties;
import cn.skill6.website.dao.intf.store.StoreImageDao;
import cn.skill6.website.util.storage.FileStoreHandler;

/**
 * 图片存储服务类
 *
 * @author 何明胜
 * @version 1.7
 * @since 2018年9月13日 上午12:45:47
 */
@Service
public class StoreImageService implements StoreImageSvc {

  @Autowired private StoreImageDao storeImageDao;

  @Autowired private FileStoreHandler fileStoreHandler;

  @Autowired private Skill6Properties skill6Properties;

  private String userHomeDir = System.getProperty("user.home");

  @Override
  public ResponseJson uploadImage(HttpServletRequest request)
      throws IOException, FileUploadException {
    String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
    String userHomeDir = System.getProperty("user.home");
    String storeParentPath = StringUtils.join(skill6Properties.getImagePath(), dateFormat);

    StoreImage storeImage = new StoreImage();
    FileAttribute fileAttribute =
        fileStoreHandler.fileUploadHandler(request, userHomeDir, storeParentPath);

    storeImage.setImageId(Long.valueOf(fileAttribute.getId()));
    storeImage.setImageName(fileAttribute.getName());
    storeImage.setImageUrl(fileAttribute.getUrl());
    storeImage.setImageHashCode(fileAttribute.getHashCode());

    storeImageDao.addImageUpload(storeImage);

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
    StoreImage storeImage = storeImageDao.findByImageId(imageId);

    String imageUrl = storeImage.getImageUrl();
    imageUrl = StringUtils.join(userHomeDir, imageUrl);
    String imageName = storeImage.getImageName();

    fileStoreHandler.fileDownloadHandler(response, imageUrl, imageName);
  }
}
