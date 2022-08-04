package com.springboot.registration.service;

import com.springboot.registration.model.User;
import com.springboot.registration.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    User save(UserRegistrationDto registrationDto);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
