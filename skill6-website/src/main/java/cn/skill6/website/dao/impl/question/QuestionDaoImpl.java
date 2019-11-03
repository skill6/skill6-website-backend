package cn.skill6.website.dao.impl.question;

import cn.skill6.common.entity.po.question.QuestionInfo;
import cn.skill6.website.dao.intf.question.QuestionDao;
import cn.skill6.website.dao.mappers.question.QuestionInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 提问答疑
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-11-03 19:10
 */
@Slf4j
@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private QuestionInfoMapper questionInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long questionId) {
        return questionInfoMapper.deleteByPrimaryKey(questionId);
    }

    @Override
    public int insert(QuestionInfo questionInfo) {
        return questionInfoMapper.insert(questionInfo);
    }

    @Override
    public QuestionInfo selectByPrimaryKey(Long questionId) {
        return questionInfoMapper.selectByPrimaryKey(questionId);
    }

    @Override
    public List<QuestionInfo> selectAll() {
        return questionInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(QuestionInfo questionInfo) {
        return questionInfoMapper.updateByPrimaryKey(questionInfo);
    }
}
