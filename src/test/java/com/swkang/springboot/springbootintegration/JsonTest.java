package com.swkang.springboot.springbootintegration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootIntegrationApplication.class})
public class JsonTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testOne(){
        redisTemplate.opsForValue().set("name", "swkang");
        String value = redisTemplate.opsForValue().get("name");
        System.out.println("value: "+value);
    }
}
