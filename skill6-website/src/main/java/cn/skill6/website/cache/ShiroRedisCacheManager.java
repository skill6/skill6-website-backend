package cn.skill6.website.cache;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * shiro缓存
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年10月23日 上午2:18:40
 */
@Service
public class ShiroRedisCacheManager extends AbstractCacheManager {

    @Autowired
    ShiroRedisCache<?, ?> cache;

    @Override
    protected Cache<?, ?> createCache(String paramString) throws CacheException {
        return cache;
    }
}
