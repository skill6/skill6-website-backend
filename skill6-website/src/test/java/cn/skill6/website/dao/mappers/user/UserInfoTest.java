package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.common.transform.JacksonUtil;
import cn.skill6.website.Skill6WebsiteApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户测试
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-27 02:21
 */
@Slf4j
@Transactional
public class UserInfoTest extends Skill6WebsiteApplicationTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testSelectByUserName() {
        UserInfo userInfo = userInfoMapper.selectByUserName("husen");
        log.info("query success, {}", JacksonUtil.toStr(userInfo));
    }

    @Test
    public void testSelectByPrimaryKey() {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1157992449180831745L);
        log.info("query success, {}", JacksonUtil.toStr(userInfo));
    }
}
