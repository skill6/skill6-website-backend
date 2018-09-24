package cn.skill6.website.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.service.basic.store.StoreImageSvc;

/**
 * 图片存储控制器
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月13日 上午12:43:33
 */
@RestController
@RequestMapping(value = "/image")
public class StoreImageController {

  @Autowired
  @Qualifier("imageUploadSvcImpl")
  private StoreImageSvc imageUploadSvc;

  @PostMapping
  public ResponseJson uploadImage(HttpServletRequest request)
      throws IOException, FileUploadException {

    return imageUploadSvc.uploadImage(request);
  }

  @GetMapping(value = "/{year}/{month}/{day}/{imageId}")
  public void downloadImageById(
      @PathVariable(name = "imageId") Long imageId, HttpServletResponse response)
      throws IOException {

    imageUploadSvc.downloadImageById(imageId, response);
  }
}
