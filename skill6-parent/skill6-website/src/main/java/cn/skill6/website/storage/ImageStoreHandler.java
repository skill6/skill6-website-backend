package cn.skill6.website.storage;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.skill6.common.constant.OsPlatform;
import cn.skill6.common.entity.po.ImageUpload;

/**
 * 图片存储处理
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年9月3日 上午1:34:51
 */
public class ImageStoreHandler extends BaseStoreHandler {
  private final Logger logger = LoggerFactory.getLogger(ImageStoreHandler.class);

  public void imageUploadHandler(HttpServletRequest request, String storeParentPath)
      throws IOException, FileUploadException {
    File parentFile = new File(storeParentPath);
    if (!parentFile.exists()) {
      parentFile.mkdirs();
      logger.info("目录{}不存在，已经创建", storeParentPath);
    }

    MultipartHttpServletRequest multiRequest = parseRequest(request);
    Iterator<String> iter = multiRequest.getFileNames();
    while (iter.hasNext()) {
      MultipartFile multipartFile = multiRequest.getFile(iter.next());
      String fileName = multipartFile.getOriginalFilename();

      // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
      // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
      fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
      String fileSuffix = getFileSuffix(fileName);
      String fileId = isFileExist(storeParentPath, fileSuffix);
      String fileUrl = storeParentPath + "/" + fileId + "." + fileSuffix;

      // 上传,分为1、windows 2、linux 和 mac
      OsPlatform currentOs = OsPlatform.getCurrentOs();
      long startTime = System.currentTimeMillis();
      if (currentOs == OsPlatform.WINDOWS) {
        storeFile(multipartFile.getInputStream(), fileUrl);
      } else {
        multipartFile.transferTo(new File(fileUrl));
      }
      long endTime = System.currentTimeMillis();
      logger.info("存储图片耗时：{}ms", endTime - startTime);

      // TODO 存储到数据库
      ImageUpload imageUpload = new ImageUpload();
      imageUpload.setImageId(Long.valueOf(fileId));
      imageUpload.setImageName(fileName);
      imageUpload.setImageUrl(fileUrl);
    }
  }

  public void imageDownloadHandler(
      HttpServletResponse response, String storeParentPath, String fileName) throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    readFile(response, storeParentPath, fileName);
  }
}
