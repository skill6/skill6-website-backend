package cn.skill6.website.security.credentials;

import cn.skill6.common.constant.RedisCachePrefix;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 密码验证服务,带失败重试次数限制
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年10月24日 上午12:41:00
 */
@Slf4j
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {
    /**
     * 密码失败次数缓存
     */
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = (String) token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(getCacheKey(userName));
        log.info("current retry count: " + retryCount);

        if (retryCount == null) {
            log.debug("retryCount 为Null, 初始化为0");

            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(getCacheKey(userName), retryCount);
        }

        // if retry count > 5 throw
        if (retryCount.incrementAndGet() > RedisCachePrefix.SHIRO_LOGIN_FAIL_MAX_COUNT) {
            log.warn("retryCount 大于5,登录失败超过5次");
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        log.info("user password matches: {}", matches);

        if (matches) {
            // if matches, clear retry count
            passwordRetryCache.remove(getCacheKey(userName));
        }

        return matches;
    }

    private String getCacheKey(String key) {
        return RedisCachePrefix.SHIRO_LOGIN_FAIL_COUNT + key;
    }
}
