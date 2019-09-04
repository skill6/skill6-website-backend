package cn.skill6.website.controller.question;

import cn.skill6.common.entity.vo.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提问答疑
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 23:01
 */
@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {

    @GetMapping
    public ResponseJson getVideos(int pageSize, int pageNum) {
        return null;
    }

    @GetMapping("/{questionId}")
    public ResponseJson getQuestionById(@PathVariable("questionId") long questionId) {
        return null;
    }

}
