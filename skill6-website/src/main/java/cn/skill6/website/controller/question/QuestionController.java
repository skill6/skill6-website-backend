package cn.skill6.website.controller.question;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.question.QuestionSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private QuestionSvc questionSvc;

    @GetMapping
    public ResponseJson geQuestions(int pageSize, int pageNum) {
        return questionSvc.geQuestions(pageSize, pageNum);
    }

    @GetMapping("/{questionId}")
    public ResponseJson getQuestionById(@PathVariable("questionId") long questionId) {
        return questionSvc.getQuestionById(questionId);
    }

}
