package cn.skill6.website.controller.basic;

import cn.skill6.common.entity.po.other.Notice;
import cn.skill6.website.basic.NoticeSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 网站通知信息
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 22:51
 */
@Slf4j
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeSvc noticeSvc;

    @GetMapping
    public List<Notice> getLatestNotice(@Param("topn") int topn) {
        log.info("getLatestNotice, topn: {}", topn);

        return noticeSvc.getLatestNotice(topn);
    }
}
