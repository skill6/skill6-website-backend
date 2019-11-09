package cn.skill6.website.dao.impl.question;

import cn.skill6.common.entity.po.question.QuestionInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.dao.intf.question.QuestionDao;
import cn.skill6.website.dao.mappers.question.QuestionInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public long insert(QuestionInfo questionInfo) {
        long questionId = SequenceManager.getNextId();

        questionInfo.setQuestionId(questionId);
        questionInfo.setQuestionValid(true);

        questionInfoMapper.insert(questionInfo);

        return questionId;
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

    public PageResult<QuestionInfo> findQuestionByPage(int pageSize, int pageNum) {
        log.info("findQuestionByPage, pageSize: {}, pageNum: {}", pageSize, pageNum);

        Page<QuestionInfo> page = PageHelper.startPage(pageNum, pageSize);

        List<QuestionInfo> questionInfos = questionInfoMapper.selectAll();
        log.info("questionInfos size: {}, total: {}", questionInfos.size(), page.getTotal());

        return new PageResult<>(page.getTotal(), pageSize, pageNum, questionInfos);
    }
}
