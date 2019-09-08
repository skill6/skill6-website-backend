package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户隐私信息mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:41:46
 */
@Mapper
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo userPrivacyInfo);

    UserInfo selectByPrimaryKey(Long userId);

    UserInfo selectByUserName(String userName);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo userPrivacyInfo);
}
