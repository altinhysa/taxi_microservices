package com.altin.tripmanagementservice.exceptions;

public class PassengerNotFoundException extends Exception{
    public PassengerNotFoundException() {
    }

    public PassengerNotFoundException(String message) {
        super(message);
    }
}
