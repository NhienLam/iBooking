package com.example.ibooking.Model;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

class UserModelTest {
UserModel k = new UserModel(0,"kk","t@gmail.com","321","408999223");


    @org.junit.jupiter.api.Test
    void getId() {

        assertEquals(0, k.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        k.setId(5);
        assertEquals(5, k.getId());
    }

    @org.junit.jupiter.api.Test
    void getUserName() {
    }

    @org.junit.jupiter.api.Test
    void setUserName() {
        assertEquals("kk", k.getUserName());
    }


    @org.junit.jupiter.api.Test
    void setUserEmail() {
        k.setUserName("qqq");
        assertEquals("qqq", k.getUserName());
    }

    @org.junit.jupiter.api.Test
    void getUserEmail() {
    }

    @org.junit.jupiter.api.Test
    void getUserPassword() {
        assertEquals("321", k.getUserPassword());
    }

    @org.junit.jupiter.api.Test
    void setUserPassword() {
        k.setUserPassword("123");
        assertEquals("123", k.getUserPassword());
    }

    @org.junit.jupiter.api.Test
    void getUserPhone() {
        assertEquals("408999223", k.getUserPhone());
    }

    @org.junit.jupiter.api.Test
    void setUserPhone() {
        k.setUserPhone("123456789");
        assertEquals("123456789", k.getUserPhone());
    }

    @org.junit.jupiter.api.Test
    void resetPassword() {
       String a =  k.resetPassword();
        assertEquals(a, k.getUserPassword());
    }

}