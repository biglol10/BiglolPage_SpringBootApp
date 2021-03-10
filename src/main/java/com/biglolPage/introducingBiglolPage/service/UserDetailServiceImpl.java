package com.biglolPage.introducingBiglolPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biglolPage.introducingBiglolPage.domain.User;
import com.biglolPage.introducingBiglolPage.domain.UserRepository;

// create a class that implements the UserDetailsService interface that's provided by Spring Security. 
// Spring Security uses this for user authentication and authorization

@Service
public class UserDetailServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    { 
      User currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core
            .userdetails.User(username, currentUser.getPassword()
            , true, true, true, true, 
            AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
    
}