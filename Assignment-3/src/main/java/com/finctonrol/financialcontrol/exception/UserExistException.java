package com.finctonrol.financialcontrol.exception;

public class UserExistException extends Exception{
    public UserExistException(String failure){
        super(failure);
    }
}
