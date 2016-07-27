package com.dileep.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dileep.registration.cache.impl.RedisCacheServiceImpl;
import com.dileep.registration.data.RegistrationResponse;
import com.dileep.registration.data.Status;
import com.dileep.registration.data.User;

@RestController
@RequestMapping("/registration/user")
public class RegistrationController {
    @Autowired
    private RedisCacheServiceImpl cacheimpl ;
    


    @RequestMapping( method = RequestMethod.GET , value="/{userid}" )
    public RegistrationResponse getUser(@PathVariable Integer userid){
        RegistrationResponse response = new RegistrationResponse();
        Status status =  new Status();
        try {
            User userFromCache = cacheimpl.getUser(userid);
            if(null == userFromCache){
                status.responsecode= ""+HttpStatus.NO_CONTENT.value();
                status.responsemessage= HttpStatus.NO_CONTENT.getReasonPhrase();
            }
            else{
                status.responsecode= ""+HttpStatus.OK.value();
                status.responsemessage= HttpStatus.OK.getReasonPhrase();
                response.user = userFromCache;
            }
        } catch (Exception e) {
            status.responsecode= ""+HttpStatus.INTERNAL_SERVER_ERROR.value();
            status.responsemessage= HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
        response.status= status;
        return response;
    }
    
    @RequestMapping( method = RequestMethod.POST )
    public RegistrationResponse createUser( @RequestBody User user){
        RegistrationResponse response =  new RegistrationResponse();
        Status status ;
        try{
            status = cacheimpl.addUser(user);
        }
        catch (Exception e) {
            status =  new Status();
            status.responsecode= ""+HttpStatus.INTERNAL_SERVER_ERROR.value();
            status.responsemessage= HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
        response.status= status;
        return response;
    }
    
   
    @RequestMapping( method = RequestMethod.DELETE , value="/{userid}" )
    public RegistrationResponse removeUser(@PathVariable Integer userid){
     
        RegistrationResponse response =  new RegistrationResponse();
        Status status ;
        try{
            status = cacheimpl.deleteUser(userid);
        }
        catch (Exception e) {
            status =  new Status();
            status.responsecode= ""+HttpStatus.INTERNAL_SERVER_ERROR.value();
            status.responsemessage= HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
        response.status= status;
        return response;
    }
}
