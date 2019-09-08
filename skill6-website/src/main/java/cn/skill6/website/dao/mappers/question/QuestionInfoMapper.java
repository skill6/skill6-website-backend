package cn.skill6.website.dao.mappers.question;

import cn.skill6.common.entity.po.question.QuestionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 提问信息mapper
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-01 02:32
 */
@Repository
public interface QuestionInfoMapper {
    int deleteByPrimaryKey(Long questionId);

    int insert(QuestionInfo questionInfo);

    QuestionInfo selectByPrimaryKey(Long questionId);

    List<QuestionInfo> selectAll();

    int updateByPrimaryKey(QuestionInfo questionInfo);
}
