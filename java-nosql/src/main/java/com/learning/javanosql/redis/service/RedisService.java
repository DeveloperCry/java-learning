package com.learning.javanosql.redis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.javanosql.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("serializedStringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    //查看RedisAutoConfiguration文件，就知道为什么这里要使用这个了
    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Autowired
    private ObjectMapper objectMapper;

    public void setUser() {
        User user = new User("wangwu", 23, "xx@email.com", "成都");

        Jackson2HashMapper mapper = new Jackson2HashMapper(objectMapper, false);
        this.stringRedisTemplate.opsForHash().putAll("wangwu", mapper.toHash(user));
    }

    public void getUser() {
        Jackson2HashMapper mapper = new Jackson2HashMapper(objectMapper, false);
        Map map = this.stringRedisTemplate.opsForHash().entries("wangwu");
        User user = objectMapper.convertValue(map, User.class);
        System.out.println(user.toString());
    }

    public void setName() {
        this.redisTemplate.opsForValue().set("name", "lisi");
        this.stringRedisTemplate.opsForValue().set("age", "16");
        this.valueOperations.set("email", "xxx@test.com");
        this.redisTemplate.getConnectionFactory().getConnection().set("address".getBytes(), "chengdu".getBytes());
    }

    public void getName() {
        String name = (String) this.redisTemplate.opsForValue().get("name");
        System.out.println("name is: " + name);
        String age = this.stringRedisTemplate.opsForValue().get("age");
        System.out.println("age is: " + age);
        String email = this.valueOperations.get("email");
        System.out.println("email is: " + email);
        String address = new String(this.redisTemplate.getConnectionFactory().getConnection().get("address".getBytes()));
        System.out.println("address is: " + address);
    }
}
