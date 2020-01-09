package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 上锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {

        //在同一时间访问时，能够设置的线程返回true，并锁住。这时候同一时间的线程就不能够设置。只能接收返回的false
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        //旧的线程value为A， 新访问的两个线程value为B。 只能有一个线程拿到锁

        //将旧的value取出来，也就是A
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //锁过期。存储的时间小于当前时间
        if (!StringUtils.isEmpty(currentValue)
            && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的value也就是A赋值到oldValue,并将客户端传来的value也就是B设置进去。
            //只能第一个线程能够成功，因为它获取到oldValue之后马上设置了新的值了
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error(" 【redis分布式锁】 解锁异常");
        }
    }

}
