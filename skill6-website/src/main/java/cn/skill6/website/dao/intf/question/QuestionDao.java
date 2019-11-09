package cn.skill6.website.dao.intf.question;

import cn.skill6.common.entity.po.question.QuestionInfo;
import cn.skill6.common.entity.vo.PageResult;

import java.util.List;

public interface QuestionDao {
    int deleteByPrimaryKey(Long questionId);

    long insert(QuestionInfo questionInfo);

    QuestionInfo selectByPrimaryKey(Long questionId);

    List<QuestionInfo> selectAll();

    int updateByPrimaryKey(QuestionInfo questionInfo);

    PageResult<QuestionInfo> findQuestionByPage(int pageSize, int pageNum);
}
