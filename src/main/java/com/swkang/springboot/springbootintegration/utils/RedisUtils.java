package com.swkang.springboot.springbootintegration.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean set(String key, String value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e){
            logger.error("sava error", e);
            return false;
        }
    }

    public boolean set(String key, String value, long timeout){
        try {
            redisTemplate.opsForValue().set(key, value, timeout);
            return true;
        } catch (Exception e){
            logger.error("sava error", e);
            return false;
        }
    }

    public String get(String key){
        String value = redisTemplate.opsForValue().get(key);
        return value;
    }

    public boolean delete(String key){
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e){
            logger.error("delete error", e);
            return false;
        }
    }


}
