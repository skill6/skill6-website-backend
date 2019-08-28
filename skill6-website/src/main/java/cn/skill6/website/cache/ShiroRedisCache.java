package cn.skill6.website.cache;

import cn.skill6.common.constant.RedisCachePrefix;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;

/**
 * shiro实现redis缓存
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年12月2日 下午10:52:40
 */
@Slf4j
@Repository
public class ShiroRedisCache<K extends Serializable, V> implements Cache<K, V> {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ValueOperations<String, Object> operations;

    @Override
    public V get(K paramK) throws CacheException {
        if (paramK == null || StringUtils.isEmpty((CharSequence) paramK)) {
            log.debug("paramK is empty");
            return null;
        }
        log.debug("redis get, paramK:{}", paramK);

        return (V) operations.get(buildKey(paramK));
    }

    @Override
    public V put(K paramK, V paramV) throws CacheException {
        if (paramK == null || StringUtils.isEmpty((CharSequence) paramK)) {
            log.debug("paramK is empty");
            return null;
        }
        log.debug("redis get, paramK:{}", paramK);
        operations.set(buildKey(paramK), paramV);

        return paramV;
    }

    @Override
    public V remove(K paramK) throws CacheException {
        if (paramK == null || StringUtils.isEmpty(String.valueOf(paramK))) {
            log.debug("paramK is empty");
            return null;
        }
        log.debug("redis get, paramK:{}", paramK);

        return (V) redisTemplate.delete(buildKey(paramK));
    }

    @Override
    public void clear() throws CacheException {
        log.debug("redis clear");

        Set<K> keys = this.keys();
        if (CollectionUtils.isEmpty(keys)) {
            return;
        }

        for (K key : keys) {
            remove(key);
        }
    }

    @Override
    public int size() {
        log.debug("redis get size");

        return redisTemplate.keys(buildKey((K) "*")).size();
    }

    @Override
    public Set<K> keys() {
        log.debug("redis get keys");

        Set<String> keys = redisTemplate.keys(this.buildKey((K) "*"));
        if (CollectionUtils.isEmpty(keys)) {
            return Collections.emptySet();
        }

        return (Set<K>) keys;
    }

    @Override
    public Collection<V> values() {
        log.debug("redis get, values");

        Set<K> keys = this.keys();

        if (CollectionUtils.isEmpty(keys)) {
            return Collections.emptyList();
        }

        List<V> values = new ArrayList<V>(keys.size());
        for (K key : keys) {
            V value = this.get(key);
            if (value != null) {
                values.add(value);
            }
        }

        return Collections.unmodifiableList(values);
    }

    private String buildKey(K paramK) {
        String paramKey = String.valueOf(paramK);

        if (StringUtils.contains(paramKey, "shiro@")) {
            return paramKey;
        }

        return StringUtils.join(RedisCachePrefix.SHIRO_REDIS_CACHE, paramKey);
    }
}
