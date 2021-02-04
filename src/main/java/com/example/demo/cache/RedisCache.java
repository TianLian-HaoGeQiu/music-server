package com.example.demo.cache;

import com.example.demo.utils.ApplicationContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;

@Slf4j
public class RedisCache implements Cache {

    private String id;

    public RedisCache(String id) {
        //缓存ID就是当前加入缓存的namespace
        log.info ("当前的缓存id: [{}]",id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

//主要使用下面的putObject和getObject、clear
    @Override//放入Redis缓存，需要给对象序列化，ID就是Mapper.xml里面的namespace
    public void putObject (Object key, Object value) {
        log.info ("放入缓存key:[{}]放入缓存的value: [{}]", key, value) ;
        getRedisTemplate().opsForHash().put(id, key.toString() , value) ;//结构类型为Hash
//        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils. getBean ( "redisTemplate") ;
    }

    @Override//从Redis缓存获取
    public Object getObject(Object key) {
        log.info ("获取缓存key:[{}]", key.toString()) ;

        return getRedisTemplate().opsForHash().get(id,key.toString());
    }

    @Override//删除指定的缓存信息
    public Object removeObject(Object o) {
        return null;
    }

    @Override//清除缓存
    public void clear() {
        log.info ("清除所有缓存信息...");
        //getRedisTemplate().opsForHash().delete(id);//在Hash里面删除指定ID的缓存信息，会出错

        //删除这个ID对应的Hash的全部缓存信息，可以避免出错
        getRedisTemplate().delete(id);
    }
//计算缓存的存储数量
    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
    //封装获取redistemplate的方法
    public RedisTemplate getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils . getBean("redisTemplate") ;
        redisTemplate.setKeySerializer (new StringRedisSerializer());//拿到key的String序列化的方式
        redisTemplate.setHashKeySerializer (new StringRedisSerializer()) ;//拿到value的哈希序列化的方式
        return redisTemplate;
    }
}
