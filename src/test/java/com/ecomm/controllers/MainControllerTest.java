package com.ecomm.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    @Test
    void allAccess() {
        //Arrange
        MainController mainController = new MainController();

        //Act
        String response = mainController.allAccess();

        //Assert
        assertEquals("Public Content.", response);
    }
}