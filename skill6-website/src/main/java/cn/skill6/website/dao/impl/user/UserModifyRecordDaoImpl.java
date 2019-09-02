package cn.skill6.website.dao.impl.user;

import cn.skill6.common.entity.po.user.UserModifyRecord;
import cn.skill6.common.exception.Skill6Exception;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.user.UserModifyRecordDao;
import cn.skill6.website.dao.mappers.user.UserModifyRecordMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 用户信息修改记录操作实现类
 *
 * @author 何明胜
 * @version 1.4
 * @since 2018年8月28日 上午12:19:34
 */
@Slf4j
@Repository
public class UserModifyRecordDaoImpl implements UserModifyRecordDao {

    @Autowired
    private UserModifyRecordMapper userModifyRecordMapper;

    @Override
    public int deleteByUserId(Long userId) {
        log.warn("删除id为{}的用户信息修改记录", userId);

        return userModifyRecordMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void addUserModifyRecord(UserModifyRecord userModifyRecord) {
        if (userModifyRecord.getUserModifyType() == null) {
            throw new NullPointerException("用户修改记录类型不能为null");
        }
        if (userModifyRecord.getUserModifyResult() == null) {
            throw new NullPointerException("用户修改记录结果不能为null");
        }

        Long userId = userModifyRecord.getUserId();
        if (userId == null) {
            userId = SequenceManager.getNextId();
        }
        userModifyRecord.setUserModifyTime(new Date());

        userModifyRecordMapper.insert(userModifyRecord);
        log.info("成功添加id为{}的用户修改记录,{}", userId, userModifyRecord);
    }

    @Override
    public UserModifyRecord findByUserId(Long userId) {
        if (userId == null) {
            throw new NullPointerException("用户修改记录id不能null");
        }

        UserModifyRecord userModifyRecord = userModifyRecordMapper.selectByPrimaryKey(userId);
        log.info("找到id为{}的用户修改记录,{}", userId, userModifyRecord);

        return userModifyRecord;
    }

    @Override
    public List<UserModifyRecord> findAll() {
        List<UserModifyRecord> userModifyRecords = userModifyRecordMapper.selectAll();
        log.info("找到所有用户修改记录,{}", userModifyRecords);

        return userModifyRecords;
    }

    @Override
    public void modifyByUserId(UserModifyRecord userModifyRecord) {
        throw new Skill6Exception("暂不支持修改用户修改记录");
    }
}
