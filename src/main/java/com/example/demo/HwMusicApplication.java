package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class HwMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwMusicApplication.class, args);
    }

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
///*    @Autowired
//    private RedisTemplate redisTemplate ;*/
//
//    @Test
//    public void test() {
//        stringRedisTemplate.opsForValue().set("name3","张三");
//    }
/*@Test
public  void TestRedis(){
    RedisProperties.Jedis jedis =new RedisProperties.Jedis("127.0.0.1",6379);
    jedis.set("name","sjm");
    String string =jedis.get("name");
    System.out.print(string);
    jedis.close();*/
//}

}

