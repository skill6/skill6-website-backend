package cn.skill6.website.controller.store;

import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.store.StoreFileSvc;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件存储控制器
 *
 * @author 何明胜
 * @since 2018年9月4日 下午9:49:27
 */
@RestController
@RequestMapping("/file")
public class StoreFileController {

    @Autowired
    private StoreFileSvc storeFileSvc;

    @PostMapping("/share")
    public ResponseJson uploadFile(HttpServletRequest request) throws IOException, FileUploadException {
        return storeFileSvc.uploadFile(request, FileType.SHARE_FILES);
    }

    @PostMapping("/attach")
    public ResponseJson uploadAttachment(HttpServletRequest request) throws IOException, FileUploadException {
        return storeFileSvc.uploadFile(request, FileType.ATTACHMENT);
    }

    @GetMapping("/{year}/{month}/{day}/{fileId}")
    public void downloadFileById(@PathVariable(name = "fileId") Long fileId, HttpServletResponse response) {
        storeFileSvc.downloadFileById(fileId, response);
    }

    @GetMapping
    public ResponseJson getFileByPage(String pageSize, String pageNum) {
        return null;
    }
}
