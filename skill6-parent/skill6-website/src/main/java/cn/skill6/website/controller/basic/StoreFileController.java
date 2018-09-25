package cn.skill6.website.controller.basic;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.skill6.common.entity.enums.FileType;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.service.basic.store.StoreFileSvc;

/**
 * 文件存储控制器
 *
 * @author 何明胜
 * @version 1.0.5
 * @since 2018年9月4日 下午9:49:27
 */
@RestController
@RequestMapping(value = "/file")
public class StoreFileController {

  @Autowired private StoreFileSvc storeFileSvc;

  @PostMapping(value = "/share")
  public ResponseJson uploadFile(HttpServletRequest request)
      throws IOException, FileUploadException {

    return storeFileSvc.uploadFile(request, FileType.SHARE_FILES);
  }

  @PostMapping(value = "/attach")
  public ResponseJson uploadAttachment(HttpServletRequest request)
      throws IOException, FileUploadException {

    return storeFileSvc.uploadFile(request, FileType.ATTACHMENT);
  }

  @GetMapping(value = "/{year}/{month}/{day}/{fileId}")
  public void downloadFileById(
      @PathVariable(name = "fileId") Long fileId, HttpServletResponse response) throws IOException {

    storeFileSvc.downloadFileById(fileId, response);
  }
}
