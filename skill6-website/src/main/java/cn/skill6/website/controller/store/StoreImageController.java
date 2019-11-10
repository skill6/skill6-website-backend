package cn.skill6.website.controller.store;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.store.StoreImageSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片存储控制器
 *
 * @author 何明胜
 * @since 2018年9月13日 上午12:43:33
 */
@RestController
@RequestMapping("/image")
public class StoreImageController {

    @Autowired
    private StoreImageSvc storeImageSvc;

    @PostMapping
    public ResponseJson uploadImage(HttpServletRequest request) {
        return storeImageSvc.uploadImage(request);
    }

    @GetMapping("/{year}/{month}/{day}/{imageId}")
    public void downloadImageById(@PathVariable("imageId") Long imageId, HttpServletResponse response) {
        storeImageSvc.downloadImageById(imageId, response);
    }
}
