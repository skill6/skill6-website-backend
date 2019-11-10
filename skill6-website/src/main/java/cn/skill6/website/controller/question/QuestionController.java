package cn.skill6.website.controller.question;

import cn.skill6.common.entity.po.question.QuestionInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.question.QuestionSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 提问答疑
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-04 23:01
 */
@Slf4j
@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionSvc questionSvc;

    @GetMapping
    public PageResult<QuestionInfo> getQuestionByPage(int pageSize, int pageNum) {
        return questionSvc.getQuestionByPage(pageSize, pageNum);
    }

    @GetMapping("/{questionId}")
    public QuestionInfo getQuestionById(@PathVariable("questionId") long questionId) {
        return questionSvc.getQuestionById(questionId);
    }

    @PostMapping
    public long addQuestion(@RequestBody QuestionInfo questionInfo) {
        log.info("addQuestion: {}", JacksonUtil.toStr(questionInfo));

        return questionSvc.addQuestion(questionInfo);
    }

}
