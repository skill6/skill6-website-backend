package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserLoginRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户登录记录mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:40:54
 */
@Repository
public interface UserLoginRecordMapper {
    int deleteByPrimaryKey(Long loginId);

    int insert(UserLoginRecord userLoginRecord);

    UserLoginRecord selectByPrimaryKey(Long loginId);

    List<UserLoginRecord> selectAll();

    int updateByPrimaryKey(UserLoginRecord userLoginRecord);
}
