package com.company.project.repositories;

import com.company.project.entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Integer> {


    public Users getUsersByFirstName(String primerNombre);

    @Query("select Users from Users where firstName like '%'+:primerNombre+'%'")
    public Users getUsers(String primerNombre);




}
