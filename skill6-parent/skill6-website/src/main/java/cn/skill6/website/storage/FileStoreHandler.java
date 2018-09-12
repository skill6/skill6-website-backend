package cn.skill6.website.storage;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.skill6.common.constant.OsPlatform;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.file.FileNotFoundException;

/**
 * 文件存储处理
 *
 * @author 何明胜
 * @version 1.0.4
 * @since 2018年9月3日 上午1:34:37
 */
@Component
public class FileStoreHandler extends BaseStoreHandler {
  private final Logger logger = LoggerFactory.getLogger(FileStoreHandler.class);

  public FileAttribute fileUploadHandler(HttpServletRequest request, String storeParentPath)
      throws IOException, FileUploadException {
    MultipartHttpServletRequest multiRequest = parseRequest(request);
    if (multiRequest.getFileMap().size() != 1) {
      throw new Skill6Exception("此种方式仅支持单次单文件上传！");
    }

    FileAttribute fileAttribute = new FileAttribute();

    File parentFile = new File(storeParentPath);
    if (!parentFile.exists()) {
      parentFile.mkdirs();
      logger.info("目录：{}不存在，已经创建", storeParentPath);
    }

    Iterator<String> iter = multiRequest.getFileNames();
    MultipartFile multipartFile = multiRequest.getFile(iter.next());
    if (multipartFile == null) {
      throw new FileNotFoundException("上传文件未找到！");
    }

    String fileName = multipartFile.getOriginalFilename();

    // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
    // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
    String fileSuffix = getFileSuffix(fileName);
    String fileId = isFileExist(storeParentPath, fileSuffix);
    String fileUrl = storeParentPath + "/" + fileId + "." + fileSuffix;
    String fileHashCode = DigestUtils.md5DigestAsHex(multipartFile.getInputStream()).toUpperCase();

    // 上传,分为1、windows 2、linux 和 mac
    OsPlatform currentOs = OsPlatform.getCurrentOs();
    long startTime = System.currentTimeMillis();
    if (currentOs == OsPlatform.WINDOWS) {
      storeFile(multipartFile.getInputStream(), fileUrl);
    } else {
      multipartFile.transferTo(new File(fileUrl));
    }
    long endTime = System.currentTimeMillis();
    logger.info("存储文件耗时：{}ms", endTime - startTime);

    fileAttribute.setId(fileId);
    fileAttribute.setName(fileName);
    fileAttribute.setUrl(fileUrl);
    fileAttribute.setHashCode(fileHashCode);

    return fileAttribute;
  }

  public void fileDownloadHandler(HttpServletResponse response, String fileUrl, String fileName)
      throws IOException {

    readFile(response, fileUrl, fileName);
  }
}
