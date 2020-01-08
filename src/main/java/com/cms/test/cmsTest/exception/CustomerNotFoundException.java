package com.cms.test.cmsTest.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException (String message){
      super(message);
    }
}
