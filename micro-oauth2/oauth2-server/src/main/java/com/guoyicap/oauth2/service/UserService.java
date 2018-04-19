package com.guoyicap.oauth2.service;

import com.guoyicap.oauth2.model.User;
import com.guoyicap.oauth2.model.api.ApiUser;

public interface UserService {

    public ApiUser createUser(final User createUserRequest);

    public ApiUser authenticate(String username, String password);

    public ApiUser getUser(String userId);

    /**
     * Save User
     *
     * @param userId
     * @param request
     */
    public ApiUser saveUser(User user);

}
