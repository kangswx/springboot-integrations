package com.swkang.springboot.springbootintegration.controller;

import com.swkang.springboot.springbootintegration.domain.JsonData;
import com.swkang.springboot.springbootintegration.domain.User;
import com.swkang.springboot.springbootintegration.utils.JsonUtils;
import com.swkang.springboot.springbootintegration.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("add")
    private Object add(){
        //redisTemplate.opsForValue().set("name", "swkang");
        redisUtils.set("name", "swkang");
        return JsonData.buildSuccess("ok");
    }

    @GetMapping("get")
    private Object get(String key){
        //String value = redisTemplate.opsForValue().get(key);
        String value = redisUtils.get(key);
        return JsonData.buildSuccess(value);
    }

    @GetMapping("delete")
    private Object delete(String key){
        //redisTemplate.delete(key);
        redisUtils.delete(key);
        return JsonData.buildSuccess("ok");
    }

    @GetMapping("save_user")
    public Object saveUser(){
        User user = new User(15, "abc", "18945454545", new Date());
        String userStr = JsonUtils.obj2String(user);
        boolean success = redisUtils.set("base:user:11", userStr);
        return JsonData.buildSuccess(success);
    }

    @GetMapping("find_user")
    public Object findUser(){
        String userStr = redisUtils.get("base:user:11");
        User user = JsonUtils.string2Obj(userStr, User.class);
        return JsonData.buildSuccess(user);
    }

}
