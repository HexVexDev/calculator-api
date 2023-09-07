package com.company.project.services;
import com.company.project.entities.Users;
import com.company.project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UsersRepository userRepo;
    @Autowired
    PasswordEncoder passencode;


    public void saveUser(Users user) {
        // Hash the user's password before saving it to the database
        String hashedPassword = passencode.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepo.save(user);
    }
}
