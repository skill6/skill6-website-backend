package cn.skill6.website.dao.intf.user;

import cn.skill6.common.entity.po.user.UserAdditionInfo;

import java.util.List;

/**
 * 用户信息操作接口
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年8月24日 上午12:30:09
 */
public interface UserAdditionInfoDao {
    int deleteByUserId(Long userId);

    void addUserAdditionInfo(UserAdditionInfo userAdditionInfo);

    UserAdditionInfo findByUserId(Long userId);

    List<UserAdditionInfo> findAll();

    void modifyByUserId(UserAdditionInfo userAdditionInfo);
}
