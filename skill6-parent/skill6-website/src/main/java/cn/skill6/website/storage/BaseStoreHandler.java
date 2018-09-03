package cn.skill6.website.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import cn.skill6.common.constant.Encode;
import cn.skill6.common.encrypt.Md5Encrypt;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.file.FileNotFoundException;
import cn.skill6.common.sequence.SequenceManager;

/**
 * 文件存储基类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月3日 下午11:34:35
 */
public abstract class BaseStoreHandler {
  public String storeFile(InputStream inputStream, String storePath) throws IOException {
    FileOutputStream out = new FileOutputStream(storePath);
    byte buffer[] = new byte[1024];
    int length = 0;

    MessageDigest messageDigest = Md5Encrypt.getMD5Instance();

    while ((length = inputStream.read(buffer)) > 0) {
      out.write(buffer, 0, length);
      messageDigest.update(buffer, 0, length);
    }

    inputStream.close();
    out.close();

    // 生成文件的MD5哈希
    return Md5Encrypt.getHashCode(messageDigest);
  }

  public void readFile(HttpServletResponse response, String storeParentPath, String fileName)
      throws IOException {
    OutputStream outputStream = response.getOutputStream();

    File file = new File(storeParentPath + "/" + fileName);
    if (!file.exists()) {
      throw new FileNotFoundException("文件未找到");
    }

    // 解决文件空格变加号问题
    String fileNameShow = URLEncoder.encode(fileName, "UTF-8");
    fileNameShow = StringUtils.replace(fileNameShow, "+", "%20");

    // 设置响应头，控制浏览器下载该文件
    response.setHeader("content-disposition", "attachment;filename=" + fileNameShow);

    String storePath = storeParentPath + "/" + fileName;

    // 读取要下载的文件，保存到文件输入流
    FileInputStream in = new FileInputStream(storePath);
    // 创建缓冲区
    byte buffer[] = new byte[1024];
    int len = 0;
    // 循环将输入流中的内容读取到缓冲区当中
    while ((len = in.read(buffer)) > 0) {
      // 输出缓冲区的内容到浏览器，实现文件下载
      outputStream.write(buffer, 0, len);
    }

    in.close();
    outputStream.close();
  }

  public List<FileItem> parseRequest(HttpServletRequest request) throws FileUploadException {
    // 使用Apache文件上传组件处理文件上传步骤：
    // 1、创建一个DiskFileItemFactory工厂
    DiskFileItemFactory factory = new DiskFileItemFactory();
    // 2、创建一个文件上传解析器
    ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
    // 解决上传文件名的中文乱码
    servletFileUpload.setHeaderEncoding(Encode.DEFAULT_ENCODE);
    // 3、判断提交上来的数据是否是上传表单的数据
    if (!ServletFileUpload.isMultipartContent(request)) {
      throw new Skill6Exception("数据不包含文件内容");
    }

    // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
    List<FileItem> list = servletFileUpload.parseRequest(request);

    return list;
  }

  public String isFileExist(String parentFilePath, String suffix) {
    String fileId;

    // 判断文件是否已经存在
    while (true) {
      fileId = SequenceManager.getNextIdStr();
      String fileName = parentFilePath + "/" + fileId + "." + suffix;
      File tempFile = new File(fileName);

      if (!tempFile.exists()) {
        return fileId;
      }
    }
  }

  /**
   * 获取文件后缀
   *
   * @return
   */
  public String getFileSuffix(String fileName) {
    // TODO - 后期增加对.tar.gz等的判断
    int index = fileName.lastIndexOf(".");
    String suffix = fileName.substring(index);

    return suffix;
  }
}
