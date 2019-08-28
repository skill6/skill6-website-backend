package cn.skill6.website.dao.mappers.user;

import cn.skill6.common.entity.po.user.UserPrivacyInfo;
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
public class UserPrivacyInfoTest extends Skill6WebsiteApplicationTest {

    @Autowired
    private UserPrivacyInfoMapper userPrivacyInfoMapper;

    @Test
    public void testSelectByUserName() {
        UserPrivacyInfo userPrivacyInfo = userPrivacyInfoMapper.selectByUserName("husen");
        log.info("query success, {}", JacksonUtil.toStr(userPrivacyInfo));
    }

    @Test
    public void testSelectByPrimaryKey() {
        UserPrivacyInfo userPrivacyInfo = userPrivacyInfoMapper.selectByPrimaryKey(1157992449180831745L);
        log.info("query success, {}", JacksonUtil.toStr(userPrivacyInfo));
    }
}
