/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guoyicap.oauth2.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserCenterDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //模拟用户,具体可以从数据库中检索相关用户
        String userId = "1";
        //123456
        String password = "e10adc3949ba59abbe56e057f20f883e";
        String image = "http://pic.shijue.me/picurl/avatar/5992fa65e4c30962c37a8e712bfa96027_d_1472712276754---jpg.jpg?code=de3cd0732028b6a6";
        String nickName = "Monkey";
        //用户所具备的权限, 具体权限可以从表中检索
        List<SimpleGrantedAuthority> roleUser = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(username, password, roleUser, userId, nickName, image);
    }


}
