package cn.skill6.service.basic;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.vo.ResponseJson;

/**
 * 文件存储接口
 *
 * @author 何明胜
 * @version 1.0.3
 * @since 2018年9月4日 下午9:44:31
 */
public interface FileDownloadSvc {
  /**
   * 上传文件
   *
   * @param request
   * @return
   * @throws FileUploadException
   * @throws IOException
   */
  public ResponseJson uploadFile(HttpServletRequest request, FileType fileType)
      throws IOException, FileUploadException;

  /**
   * @param fileId
   * @param response
   * @return
   * @throws IOException
   */
  public void downloadFileById(Long fileId, HttpServletResponse response) throws IOException;
}
