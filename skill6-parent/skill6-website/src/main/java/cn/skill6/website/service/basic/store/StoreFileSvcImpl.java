package cn.skill6.website.service.basic.store;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.po.store.StoreFile;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.microservice.basic.store.StoreFileSvc;
import cn.skill6.website.config.Skill6Properties;
import cn.skill6.website.dao.intf.store.StoreFileDao;
import cn.skill6.website.util.storage.FileStoreHandler;

/**
 * 文件存储服务类
 *
 * @author 何明胜
 * @version 1.9
 * @since 2018年9月3日 下午11:03:31
 */
@Service
public class StoreFileSvcImpl implements StoreFileSvc {

  @Resource(name = "storeFileDaoOper")
  private StoreFileDao storeFileDao;

  @Autowired private FileStoreHandler fileStoreHandler;

  @Autowired private Skill6Properties skill6Properties;

  @Override
  public ResponseJson uploadFile(HttpServletRequest request, FileType fileType)
      throws IOException, FileUploadException {
    String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
    String storeParentPath = skill6Properties.getFilePath() + dateFormat;

    FileAttribute fileAttribute = fileStoreHandler.fileUploadHandler(request, storeParentPath);
    StoreFile storeFile = new StoreFile();

    storeFile.setFileId(Long.valueOf(fileAttribute.getId()));
    storeFile.setFileName(fileAttribute.getName());
    storeFile.setFileUrl(fileAttribute.getUrl());
    storeFile.setFileHashCode(fileAttribute.getHashCode());
    storeFile.setFileType(fileType);

    storeFileDao.addFileDownload(storeFile);

    Map<String, String> resultMap = new HashMap<String, String>(5);
    resultMap.put("information", "上传成功");

    StringBuffer contextUrl = RequestParser.parseContextIndex(request);
    String fileUrl =
        contextUrl
            .append("/file/")
            .append(dateFormat)
            .append("/")
            .append(storeFile.getFileId())
            .toString();
    resultMap.put("file_url", fileUrl);

    return new ResponseJson(true, resultMap);
  }

  @Override
  public void downloadFileById(Long fileId, HttpServletResponse response) throws IOException {
    StoreFile storeFile = storeFileDao.findByFileId(fileId);

    String fileUrl = storeFile.getFileUrl();
    String fileName = storeFile.getFileName();

    fileStoreHandler.fileDownloadHandler(response, fileUrl, fileName);
  }
}
