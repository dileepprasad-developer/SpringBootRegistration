package com.dileep.registration.controller;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dileep.registration.data.RegistrationResponse;
import com.dileep.registration.data.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring/application-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationControllerTest {

    @Autowired
    private RegistrationController register;

    User testUser;
    Integer userid;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        testUser = new User();
        testUser.userid = 100;
        testUser.registrationdate = new Date();
        testUser.emailid = "someone@somewhere.com";
        testUser.username = "John Doe";

        userid = 100;

    }

    @Test
    public void test1_createUser_happy() {
        RegistrationResponse response = register.createUser(testUser);
        Assert.assertEquals( "" + HttpStatus.OK.value() , response.status.responsecode);
    }

    @Test
    public void test2_createUser_fail() {
        RegistrationResponse response = register.createUser(testUser);
        Assert.assertEquals("" + HttpStatus.ALREADY_REPORTED.value() ,response.status.responsecode);
    }

    @Test
    public void test3_getUser_happy() {
        RegistrationResponse response = register.getUser(userid);
        Assert.assertEquals("200", response.status.responsecode);
    }

    @Test
    public void test4_getUser_fail() {
        userid = 2;
        RegistrationResponse response = register.getUser(userid);
        Assert.assertEquals( "204", response.status.responsecode);
    }

    @Test
    public void test5_deleteUser_success() {
        RegistrationResponse response = register.removeUser(userid);
        Assert.assertEquals("200" ,response.status.responsecode);
    }

    
    @After
    public void tearDown() throws Exception {
       
    }

}
