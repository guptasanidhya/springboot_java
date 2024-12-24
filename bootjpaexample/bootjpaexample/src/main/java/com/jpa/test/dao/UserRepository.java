package com.jpa.test.dao;

import com.jpa.test.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User,Integer> {
//jpa repositity bhi extend kar sakte

//    public List<User> findByName(String name);
//    public List<User> findByNameAndCity(String name,String City);
//    public List<User> findByNameStartingWith(String name);
//    public List<User> findByNameEndingWith(String name);
//    public List<User> findByNameLike(String name);
    public List<User> findByNameContaining(String name);
}
