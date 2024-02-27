package com.finctonrol.financialcontrol.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String failure){
        super(failure);
    }

}
