package com.company.project.services;

import com.company.project.entities.Users;
import com.company.project.repositories.UsersRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements ServiceInterface<Users> {

@Autowired
UsersRepository repo;


    @Override
    public void add(Users newOne) {
        repo.save(newOne);
    }

    @Override
    public void remove(Users toDelete) {
        repo.delete(toDelete);
    }

    @Override
    public List<Users> getAll() {
        return IteratorUtils.toList(repo.findAll().iterator());
    }

    @Override
    public void saveOrUpdate(Users toUpdate) {
        repo.save(toUpdate);
    }
}
