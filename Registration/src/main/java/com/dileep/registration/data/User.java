package com.dileep.registration.data;

import java.io.Serializable;
import java.security.CryptoPrimitive;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8799604175718952903L;
    @JsonFormat
    public String userid;
    @JsonFormat
    public String username;
    @JsonFormat
    public String emailid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date registrationdate;
    public User(){
        
    }
    public User(String userid , String username , String emailid , Date registrationdate){
        this.userid =  userid;
        this.username =  username;
        this.emailid =  emailid;
        this .registrationdate = registrationdate;
    }
}
