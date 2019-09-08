package cn.skill6.website.service.store;

import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.po.store.StoreFile;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.common.utility.DateFormat;
import cn.skill6.common.utility.RequestParser;
import cn.skill6.website.config.Skill6PropertyConfig;
import cn.skill6.website.dao.intf.store.StoreFileDao;
import cn.skill6.website.store.StoreFileSvc;
import cn.skill6.website.util.storage.FileStoreHandler;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件存储服务类
 *
 * @author 何明胜
 * @since 2018年9月3日 下午11:03:31
 */
@Service
public class StoreFileService implements StoreFileSvc {

    @Autowired
    private StoreFileDao storeFileDao;

    @Autowired
    private FileStoreHandler fileStoreHandler;

    @Autowired
    private Skill6PropertyConfig skill6PropertyConfig;

    private String userHomeDir = System.getProperty("user.home");

    @Override
    public ResponseJson uploadFile(HttpServletRequest request, FileType fileType) throws IOException, FileUploadException {
        String dateFormat = DateFormat.formatDateYMD("yyyy/MM/dd");
        String storeParentPath = StringUtils.join(skill6PropertyConfig.getFilePath(), dateFormat);

        FileAttribute fileAttribute = fileStoreHandler.fileUploadHandler(request, userHomeDir, storeParentPath);
        StoreFile storeFile = new StoreFile();

        storeFile.setFileId(Long.valueOf(fileAttribute.getId()));
        storeFile.setFileName(fileAttribute.getName());
        storeFile.setFileFullName(fileAttribute.getName());
        storeFile.setFileUrl(fileAttribute.getUrl());
        storeFile.setFileHashCode(fileAttribute.getHashCode());
        // 文件标签待完善
        storeFile.setFileLabel("book");
        storeFile.setFileVisitCount(0);
        storeFile.setFileCollectCount(0);
        storeFile.setFileType(fileType);

        storeFileDao.addFileDownload(storeFile);

        Map<String, String> resultMap = new HashMap<String, String>(5);
        resultMap.put("information", "上传成功");

        StringBuffer contextUrl = RequestParser.parseContextIndex(request);
        String fileUrl = contextUrl
            .append("/file/")
            .append(dateFormat)
            .append("/")
            .append(storeFile.getFileId())
            .toString();
        resultMap.put("file_url", fileUrl);

        return new ResponseJson(resultMap);
    }

    @Override
    public void downloadFileById(Long fileId, HttpServletResponse response) {
        StoreFile storeFile = storeFileDao.findByFileId(fileId);

        String fileUrl = storeFile.getFileUrl();
        fileUrl = StringUtils.join(userHomeDir, fileUrl);
        String fileName = storeFile.getFileName();

        fileStoreHandler.fileDownloadHandler(response, fileUrl, fileName);
    }
}
