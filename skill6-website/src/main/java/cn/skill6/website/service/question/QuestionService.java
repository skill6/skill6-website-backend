package cn.skill6.website.service.question;

import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.question.QuestionSvc;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 提问答疑服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-08 21:48
 */
@Slf4j
@Service
@Component
public class QuestionService implements QuestionSvc {

    @Override
    public ResponseJson geQuestions(int pageSize, int pageNum) {
        return null;
    }

    @Override
    public ResponseJson getQuestionById(long questionId) {
        return null;
    }
}
