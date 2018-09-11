package cn.skill6.website.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.po.FileDownload;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.service.basic.FileDownloadSvc;
import cn.skill6.website.constant.Constant;
import cn.skill6.website.dao.intf.FileDownloadOper;
import cn.skill6.website.storage.FileStoreHandler;

/**
 * 文件存储服务类
 *
 * @author 何明胜
 * @version 1.0.1
 * @since 2018年9月3日 下午11:03:31
 */
@Service
public class FileDownloadSvcImpl implements FileDownloadSvc {

  @Autowired
  @Qualifier("fileDownloadImpl")
  private FileDownloadOper fileDownloadOper;

  @Autowired private FileStoreHandler fileStoreHandler;

  /* (non-Javadoc)
   * @see cn.skill6.service.basic.FileDownloadSvc#uploadFile(javax.servlet.http.HttpServletRequest)
   */
  @Override
  public ResponseJson uploadFile(HttpServletRequest request)
      throws IOException, FileUploadException {
    String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
    String storeParentPath = Constant.FILE_STORE_ROOT_PATH + dateFormat;

    FileDownload fileDownload = fileStoreHandler.fileUploadHandler(request, storeParentPath);

    fileDownloadOper.addFileDownload(fileDownload);

    @SuppressWarnings("unchecked")
    Map<String, String> resultMap = new HashedMap(5);
    resultMap.put("information", "上传成功");

    StringBuffer url = request.getRequestURL();
    String contextUrl =
        url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    String fileUrl = contextUrl + "/file/" + dateFormat + "/" + fileDownload.getFileId();
    resultMap.put("file_url", fileUrl);

    return new ResponseJson(true, resultMap);
  }

  /* (non-Javadoc)
   * @see cn.skill6.service.basic.FileDownloadSvc#downloadFileById(java.lang.Long)
   */ @Override
  public void downloadFileById(Long fileId, HttpServletResponse response) throws IOException {
    FileDownload fileDownload = fileDownloadOper.findByFileId(fileId);

    String fileUrl = fileDownload.getFileUrl();
    String fileName = fileDownload.getFileName();

    fileStoreHandler.fileDownloadHandler(response, fileUrl, fileName);
  }
}
