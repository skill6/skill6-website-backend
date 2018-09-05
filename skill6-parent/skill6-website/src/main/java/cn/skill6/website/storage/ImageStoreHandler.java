package cn.skill6.website.storage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.skill6.common.constant.Encode;
import cn.skill6.common.entity.po.ImageUpload;
import cn.skill6.common.exception.file.FileNotFoundException;

/**
 * 图片存储处理
 *
 * @author 何明胜
 * @version 1.0.2
 * @since 2018年9月3日 上午1:34:51
 */
public class ImageStoreHandler extends BaseStoreHandler {
  private final Logger logger = LoggerFactory.getLogger(ImageStoreHandler.class);

  public void imageUploadHandler(HttpServletRequest request, String storeParentPath)
      throws IOException, FileUploadException {
    File parentFile = new File(storeParentPath);

    if (!parentFile.isDirectory()) {
      throw new FileNotFoundException("参数不为目录");
    }

    if (!parentFile.exists()) {
      parentFile.mkdirs();
      logger.info("目录{}不存在，已经创建", storeParentPath);
    }

    List<FileItem> list = parseRequest(request);
    for (FileItem item : list) {
      // 如果fileitem中封装的是普通输入项的数据
      if (item.isFormField()) {
        String name = item.getFieldName();
        // 解决普通输入项的数据的中文乱码问题
        String value = item.getString(Encode.DEFAULT_ENCODE);
        logger.info("普通表单（暂不处理）：{}={}", name, value);
      } else {
        // 如果fileitem中封装的是上传文件
        // 得到上传的文件名称
        String fileName = item.getName();
        if (fileName == null || fileName.trim().equals("")) {
          continue;
        }

        // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
        // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        String fileSuffix = getFileSuffix(fileName);
        String fileId = isFileExist(storeParentPath, fileSuffix);
        String fileUrl = storeParentPath + "/" + fileId + "." + fileSuffix;

        // 获取item中的上传文件的输入流
        InputStream in = item.getInputStream();
        storeFile(in, fileUrl);

        // 删除处理文件上传时生成的临时文件
        item.delete();
        logger.info("上传文件url：{}", fileUrl);
        
        // TODO 存储到数据库
        ImageUpload imageUpload = new ImageUpload();
        imageUpload.setImageId(Long.valueOf(fileId));
        imageUpload.setImageName(fileName);
        imageUpload.setImageUrl(fileUrl);
      }
    }
  }

  public void imageDownloadHandler(
      HttpServletResponse response, String storeParentPath, String fileName) throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    readFile(response, storeParentPath, fileName);
  }
}
