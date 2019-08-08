package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.microservice.basic.store.StoreImageSvc;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 图片存储控制器
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月13日 上午12:43:33
 */
@RestController
@RequestMapping(value = "/image")
public class StoreImageController {

    @Autowired
    private StoreImageSvc storeImageSvc;

    @PostMapping
    public ResponseJson uploadImage(HttpServletRequest request)
            throws IOException, FileUploadException {

        return storeImageSvc.uploadImage(request);
    }

    @GetMapping(value = "/{year}/{month}/{day}/{imageId}")
    public void downloadImageById(
            @PathVariable(name = "imageId") Long imageId, HttpServletResponse response)
            throws IOException {

        storeImageSvc.downloadImageById(imageId, response);
    }
}
