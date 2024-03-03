package com.submerge.subfriends.service;
import java.util.Date;

import com.submerge.subfriends.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * ClassName: RedisTest
 * Package: com.submerge.subfriends.service
 * Description:
 *
 * @Author Submerge--WangDong
 * @Create 2024-03-02 13:23
 * @Version 1.0
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("key1","21");
        valueOperations.set("key2",2.8);
        User user = new User();
        user.setUserName("小栋");

        valueOperations.set("key3",user);

        System.out.println(valueOperations.get("key1"));
        System.out.println(valueOperations.get("key2"));
        System.out.println(valueOperations.get("key3"));
    }
}
