package cn.skill6.website.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

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
 * @version 1.0.0
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

    return new ResponseJson(true, "上传成功");
  }
}
