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

import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.po.FileDownload;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.service.basic.FileDownloadSvc;
import cn.skill6.website.config.Skill6Properties;
import cn.skill6.website.dao.intf.FileDownloadOper;
import cn.skill6.website.util.storage.FileStoreHandler;

/**
 * 文件存储服务类
 *
 * @author 何明胜
 * @version 1.0.4
 * @since 2018年9月3日 下午11:03:31
 */
@Service
public class FileDownloadSvcImpl implements FileDownloadSvc {

  @Autowired
  @Qualifier("fileDownloadImpl")
  private FileDownloadOper fileDownloadOper;

  @Autowired private FileStoreHandler fileStoreHandler;

  @Autowired private Skill6Properties skill6Properties;

  @Override
  public ResponseJson uploadFile(HttpServletRequest request, FileType fileType)
      throws IOException, FileUploadException {
    String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
    String storeParentPath = skill6Properties.getFilePath() + dateFormat;

    FileAttribute fileAttribute = fileStoreHandler.fileUploadHandler(request, storeParentPath);
    FileDownload fileDownload = new FileDownload();

    fileDownload.setFileId(Long.valueOf(fileAttribute.getId()));
    fileDownload.setFileName(fileAttribute.getName());
    fileDownload.setFileUrl(fileAttribute.getUrl());
    fileDownload.setFileHashCode(fileAttribute.getHashCode());
    fileDownload.setFileType(fileType);

    fileDownloadOper.addFileDownload(fileDownload);

    Map<String, String> resultMap = new HashMap<String, String>(5);
    resultMap.put("information", "上传成功");

    StringBuffer contextUrl = RequestParser.parseContextIndex(request);
    String fileUrl =
        contextUrl
            .append("/file/")
            .append(dateFormat)
            .append("/")
            .append(fileDownload.getFileId())
            .toString();
    resultMap.put("file_url", fileUrl);

    return new ResponseJson(true, resultMap);
  }

  @Override
  public void downloadFileById(Long fileId, HttpServletResponse response) throws IOException {
    FileDownload fileDownload = fileDownloadOper.findByFileId(fileId);

    String fileUrl = fileDownload.getFileUrl();
    String fileName = fileDownload.getFileName();

    fileStoreHandler.fileDownloadHandler(response, fileUrl, fileName);
  }
}
