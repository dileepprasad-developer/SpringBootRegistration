package com.dileep.registration.data;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8799604175718952903L;
    @JsonFormat
    public Integer userid;
    @JsonFormat
    public String username;
    @JsonFormat
    public String emailid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date registrationdate;
    public User(){
        
    }
    public User(Integer userid , String username , String emailid , Date registrationdate){
        this.userid =  userid;
        this.username =  username;
        this.emailid =  emailid;
        this .registrationdate = registrationdate;
    }
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      User user = (User) o;

      if (userid != null ? !userid.equals(user.userid) : user.userid != null) return false;

      return true;
    }

    @Override
    public int hashCode() {
      return userid != null ? userid.hashCode() : 0;
    }
}
