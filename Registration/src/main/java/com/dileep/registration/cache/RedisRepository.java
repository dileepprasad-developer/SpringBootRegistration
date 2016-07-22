package com.dileep.registration.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.dileep.registration.data.User;
@Service
public  class RedisRepository    {
   
    @Autowired
    protected RedisTemplate<String, User> redistemplate;  
    
    public RedisTemplate<String, User> getRedistemplate() {
        return redistemplate;
    }

    public void setRedistemplate(RedisTemplate<String, User> redistemplate) {
        this.redistemplate = redistemplate;
    }

    public void add(String key, User value) {
        redistemplate.opsForValue().set(key, value);
    }
  
    public User getValue(String key) {
       return redistemplate.opsForValue().get(key);
    }
  
    public void delete(String key) {
        redistemplate.opsForValue().getOperations().delete(key);
    }
}
