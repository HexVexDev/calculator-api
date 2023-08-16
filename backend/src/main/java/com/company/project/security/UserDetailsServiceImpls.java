package com.company.project.security;

import com.company.project.entities.Users;
import com.company.project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpls implements UserDetailsService {
    @Autowired
    private UsersRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users user=  userRepository
                .findOneByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("El Usuario con username "+ username +" no existe."));
        return new UserDetailsImpl(user);
    }
}
