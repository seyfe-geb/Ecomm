package com.ecomm.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerUnitTest {

    @Test
    void adminAccess() {

        //ARRANGE
        UserController userController = new UserController();
        //ACT
        String response = userController.adminAccess();
        //ASSERT
        assertEquals("Admin Board.", response);
    }

    @Test
    void sellerAccess() {
        //ARRANGE
        UserController userController = new UserController();
        //ACT
        String response = userController.sellerAccess();
        //ASSERT
        assertEquals("Seller Board.", response);
    }

    @Test
    void buyerAccess() {
        //ARRANGE
        UserController userController = new UserController();
        //ACT
        String response = userController.buyerAccess();
        //ASSERT
        assertEquals("Buyer Board.", response);
    }

    @Test
    void allAccess() {
        //ARRANGE
        UserController userController = new UserController();
        //ACT
        String response = userController.allAccess();
        //ASSERT
        assertEquals("Public Content.", response);
    }
}