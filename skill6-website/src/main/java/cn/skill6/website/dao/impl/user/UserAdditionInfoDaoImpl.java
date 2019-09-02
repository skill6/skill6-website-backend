package cn.skill6.website.dao.impl.user;

import cn.skill6.common.entity.po.user.UserAdditionInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.common.utility.RandomCode;
import cn.skill6.website.dao.intf.user.UserAdditionInfoDao;
import cn.skill6.website.dao.mappers.user.UserAdditionInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 用户信息操作实现类
 *
 * @author 何明胜
 * @version 1.5
 * @since 2018年8月28日 上午12:19:19
 */
@Slf4j
@Repository
public class UserAdditionInfoDaoImpl implements UserAdditionInfoDao {

    @Autowired
    private UserAdditionInfoMapper userAdditionInfoMapper;

    @Override
    public int deleteByUserId(Long userId) {
        log.warn("删除id为{}的用户信息", userId);

        return userAdditionInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void addUserAdditionInfo(UserAdditionInfo userAdditionInfo) {
        if (userAdditionInfo.getUserId() == null) {
            //TODO - 打印日志
            throw new NullPointerException("用户id不能为null");
        }

        if (userAdditionInfo.getUserNickName() == null) {
            userAdditionInfo.setUserNickName("用户" + RandomCode.producedRandomCodeStr6());
        }
        userAdditionInfo.setUserRegisterDate(new Date());

        userAdditionInfoMapper.insert(userAdditionInfo);
    }

    @Override
    public UserAdditionInfo findByUserId(Long userId) {
        if (userId == null) {
            throw new NullPointerException("用户id不能为空");
        }

        UserAdditionInfo userAdditionInfo = userAdditionInfoMapper.selectByPrimaryKey(userId);
        log.info("找到id为{}的用户其他信息,{}", userId, userAdditionInfo);

        return userAdditionInfo;
    }

    @Override
    public List<UserAdditionInfo> findAll() {
        List<UserAdditionInfo> userAdditionInfos = userAdditionInfoMapper.selectAll();
        log.info("找到所有用户额外信息,{}", userAdditionInfos);

        return userAdditionInfos;
    }

    @Override
    public void modifyByUserId(UserAdditionInfo userAdditionInfo) {
        if (userAdditionInfo.getUserId() == null) {
            throw new NullPointerException("用户id不能为null");
        }

        userAdditionInfoMapper.updateByPrimaryKey(userAdditionInfo);
        log.info("成功修改id为{}的用户额外信息", userAdditionInfo.getUserId());
    }
}
