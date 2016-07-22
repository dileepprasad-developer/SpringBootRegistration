package com.dileep.registration.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({RegistrationControllerTest.class})
public class JunitTestSuite {  
    public static void main(String args[]) {
        JUnitCore.runClasses(JunitTestSuite.class);
}
}
