package com.example.service;

import com.example.dao.UserRepository;
import com.example.dao.UserRolesRepository;
import com.example.entity.CustomUserDetails;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatabaseUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public DatabaseUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            return new CustomUserDetails(user, userRoles);
        }
    }

}