package com.dileep.registration.controller;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dileep.registration.controller.RegistrationController;
import com.dileep.registration.data.RegistrationResponse;
import com.dileep.registration.data.User;
public class RedisCacheExample {
    private static ApplicationContext ctx;

    public static void main(String[] args) {

        /*ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        RegistrationController service = ctx.getBean(RegistrationController.class);

       // System.out.println("message: " + service.createUser(new User("2" ,"foo"  , "foo@foo.com" , new Date())));
        RegistrationResponse us = service.getUser(18);
        System.out.println("message: "  + us.user.emailid +" ==>"+us.user.userid +" ==>"+ 
        us.user.username +"==>"+us.user.registrationdate);

        System.out.println("Done.");*/
    }
}
