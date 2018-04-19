package com.guoyicap.oauth2.exception;

import com.guoyicap.micro.common.exception.BaseWebApplicationException;

/**
 * @version 1.0
 * @author: Iain Porter
 * @since 13/05/2013
 */
public class UserNotFoundException extends BaseWebApplicationException {

    public UserNotFoundException() {
        super(404, "User Not Found", "No User could be found for that Id");
    }
}
