package com.emart.zuul.service.impl;

import com.emart.zuul.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
    @Autowired
    private RestTemplate restTemplate;

	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

      	UserDetails userDetails = restTemplate.getForObject("http://SERVICE-USER/user?username=" +  userName, User.class );

        return userDetails;
    }
}
