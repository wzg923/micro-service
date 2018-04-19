package com.guoyicap.oauth2.exception;

import com.guoyicap.micro.common.exception.BaseWebApplicationException;


public class AuthenticationException extends BaseWebApplicationException {

    public AuthenticationException() {
        super(401, "Authentication Error", "Authentication Error. The username or password were incorrect");
    }
}