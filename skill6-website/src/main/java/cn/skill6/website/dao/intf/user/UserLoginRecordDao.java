package cn.skill6.website.dao.intf.user;

import cn.skill6.common.entity.po.user.UserLoginRecord;

import java.util.List;

/**
 * 登录记录操作接口
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月24日 上午12:29:04
 */
public interface UserLoginRecordDao {
    int deleteByLoginId(Long loginId);

    void addLoginRecord(UserLoginRecord userLoginRecord);

    UserLoginRecord findByLoginId(Long loginId);

    List<UserLoginRecord> findAll();

    void modifyByLoginId(UserLoginRecord userLoginRecord);
}
