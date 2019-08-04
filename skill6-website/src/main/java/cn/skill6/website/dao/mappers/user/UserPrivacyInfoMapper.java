package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户隐私信息mapper
 *
 * @author 何明胜
 * @version 1.3
 * @since 2018年8月15日 下午11:41:46
 */
@Mapper
public interface UserPrivacyInfoMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(UserPrivacyInfo userPrivacyInfo);

    UserPrivacyInfo selectByPrimaryKey(Long userId);

    List<UserPrivacyInfo> selectAll();

    int updateByPrimaryKey(UserPrivacyInfo userPrivacyInfo);
}
