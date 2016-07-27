package com.dileep.registration.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.dileep.registration.cache.RedisRepository;
import com.dileep.registration.data.Status;
import com.dileep.registration.data.User;
public class RedisCacheServiceImpl implements CacheService {
    @Autowired
    private RedisRepository cacheutil ;
    
    @Override
    public User getUser(Integer userid){
        User userFromCache = cacheutil.getValue(userid);
        return userFromCache;
    }
    @Override
    public Status addUser( User user){
        Status status =  new Status();
        User existinguser =getUser(user.userid);
        if(null == existinguser){
            cacheutil.add(user.userid, user);
            status.responsecode = ""+ HttpStatus.OK.value();
            status.responsemessage = HttpStatus.OK.getReasonPhrase();
        }
        else{
            status.responsecode = ""+ HttpStatus.ALREADY_REPORTED.value();
            status.responsemessage = HttpStatus.ALREADY_REPORTED.getReasonPhrase();
        }
         return status ;   
    }
    @Override
    public Status deleteUser(Integer userid) {
        Status status = new Status();
        status.responsecode = "" + HttpStatus.INTERNAL_SERVER_ERROR.value();
        status.responsemessage = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        cacheutil.delete(""+userid);
        status.responsecode = "" + HttpStatus.OK.value();
        status.responsemessage = HttpStatus.OK.getReasonPhrase();

        return status;
    }
    
}
