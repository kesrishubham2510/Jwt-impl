package com.myreflectionthoughts.secmo.service;

import com.myreflectionthoughts.secmo.entity.User;
import com.myreflectionthoughts.secmo.entity.UserPrincipal;
import com.myreflectionthoughts.secmo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserPrincipal userPrincipal = null;
        User user = userRepository.findByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("The user:- "+username+" doesn't exist");
        }else{
            userPrincipal = new UserPrincipal(user);
        }

        return userPrincipal;
    }
}