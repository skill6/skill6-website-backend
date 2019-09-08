package cn.skill6.website.util.storage;

import cn.skill6.common.constant.OsPlatform;
import cn.skill6.common.entity.vo.FileAttribute;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.file.FileNotFoundException;
import cn.skill6.website.util.storage.abst.BaseStoreHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 文件存储处理
 *
 * @author 何明胜
 * @since 2018年9月3日 上午1:34:37
 */
@Slf4j
@Component
public class FileStoreHandler extends BaseStoreHandler {

    /**
     * 文件存储处理
     *
     * @param request         HTTP请求
     * @param rootDirPath     绝对根路径
     * @param relativeDirPath 相对路径
     * @return 文件属性
     */
    public FileAttribute fileUploadHandler(HttpServletRequest request, String rootDirPath, String relativeDirPath) {
        MultipartHttpServletRequest multiRequest = parseRequest(request);
        if (multiRequest.getFileMap().size() != 1) {
            throw new Skill6Exception("此种方式仅支持单次单文件上传！");
        }

        FileAttribute fileAttribute = new FileAttribute();

        String fileDirPath = StringUtils.join(rootDirPath, relativeDirPath);
        File parentFile = new File(fileDirPath);
        if (!parentFile.exists()) {
            boolean mkdirs = parentFile.mkdirs();
            log.info("directory: {} not exist, create result: {}", fileDirPath, mkdirs);
            if (!mkdirs) {
                throw new FileNotFoundException("create directory failed");
            }
        }

        Iterator<String> iter = multiRequest.getFileNames();
        MultipartFile multipartFile = multiRequest.getFile(iter.next());
        if (multipartFile == null) {
            throw new FileNotFoundException("上传文件未找到！");
        }

        String fileName = multipartFile.getOriginalFilename();

        // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
        // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
        if (StringUtils.isEmpty(fileName)) {
            throw new Skill6Exception("fileName is empty");
        }
        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        String fileSuffix = getFileSuffix(fileName);
        String fileId = isFileExist(fileDirPath, fileSuffix);

        // 先取得相对路径，再与根路径相加
        String relativePath = relativeDirPath + "/" + fileId + "." + fileSuffix;
        String fileUrl = StringUtils.join(rootDirPath, relativePath);

        try {
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
            log.info("存储文件耗时：{}ms", endTime - startTime);

            fileAttribute.setId(fileId);
            fileAttribute.setName(fileName);
            fileAttribute.setUrl(relativePath);
            fileAttribute.setHashCode(fileHashCode);
        } catch (IOException e) {
            log.error("upload file error", e);
            throw new Skill6Exception("upload file error", e);
        }

        return fileAttribute;
    }

    public void fileDownloadHandler(HttpServletResponse response, String fileUrl, String fileName) {
        try {
            readFile(response, fileUrl, fileName);
        } catch (IOException e) {
            log.error("down file error", e);
            throw new Skill6Exception("down file error", e);
        }
    }
}
