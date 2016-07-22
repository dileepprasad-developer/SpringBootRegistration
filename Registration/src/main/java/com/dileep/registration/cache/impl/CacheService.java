package com.dileep.registration.cache.impl;

import com.dileep.registration.data.Status;
import com.dileep.registration.data.User;

public interface CacheService {
    public User getUser(String userid);
    public Status addUser( User user);
    public Status deleteUser(String userid);

}
