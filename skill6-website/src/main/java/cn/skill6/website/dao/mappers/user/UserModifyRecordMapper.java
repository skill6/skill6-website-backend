package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserModifyRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息修改记录mapper
 *
 * @author 何明胜
 * @since 2018年8月15日 下午11:41:32
 */
@Repository
public interface UserModifyRecordMapper {
    int deleteByPrimaryKey(Long userModifyId);

    int insert(UserModifyRecord userModifyRecord);

    UserModifyRecord selectByPrimaryKey(Long userModifyId);

    List<UserModifyRecord> selectAll();

    int updateByPrimaryKey(UserModifyRecord userModifyRecord);
}