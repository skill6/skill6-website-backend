package cn.skill6.website.dao.intf.user;

import cn.skill6.common.entity.po.user.UserModifyRecord;

import java.util.List;

/**
 * 用户修改记录操作接口
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月24日 上午12:30:23
 */
public interface UserModifyRecordDao {
    int deleteByUserId(Long userId);

    void addUserModifyRecord(UserModifyRecord userModifyRecord);

    UserModifyRecord findByUserId(Long userId);

    List<UserModifyRecord> findAll();

    void modifyByUserId(UserModifyRecord userModifyRecord);
}
