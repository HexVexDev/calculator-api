package com.company.project.services;

import com.company.project.entities.Users;
import com.company.project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    UsersRepository userRepo;
    public void saveUser(Users user){
        userRepo.save(user);
    }
    public Users getUserByNameAndPassword(String name){
        return userRepo.find(name);
    }
}
