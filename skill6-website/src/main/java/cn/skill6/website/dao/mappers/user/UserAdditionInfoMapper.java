package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户附加信息mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:41:20
 */
@Repository
public interface UserAdditionInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserAdditionInfo userAdditionInfo);

    UserAdditionInfo selectByPrimaryKey(Long userId);

    List<UserAdditionInfo> selectAll();

    int updateByPrimaryKey(UserAdditionInfo userAdditionInfo);
}
