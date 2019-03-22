package com.swkang.springboot.springbootintegration.controller;

import com.swkang.springboot.springbootintegration.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("add")
    private Object add(){
        redisTemplate.opsForValue().set("name", "swkang");
        return JsonData.buildSuccess("ok");
    }

    @GetMapping("get")
    private Object get(String key){
        String value = redisTemplate.opsForValue().get(key);
        return JsonData.buildSuccess(value);
    }

    @GetMapping("delete")
    private Object delete(String key){
        redisTemplate.delete(key);
        return JsonData.buildSuccess("ok");
    }

}
