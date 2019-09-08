package cn.skill6.website.dao.mappers.question;

import cn.skill6.common.entity.po.question.QuestionAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 提问回答mapper
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-01 02:30
 */
@Repository
public interface QuestionAnswerMapper {
    int deleteByPrimaryKey(Long answerId);

    int insert(QuestionAnswer questionAnswer);

    QuestionAnswer selectByPrimaryKey(Long answerId);

    List<QuestionAnswer> selectAll();

    int updateByPrimaryKey(QuestionAnswer questionAnswer);
}
