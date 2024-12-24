package com.jpa.test.dao;

import com.jpa.test.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer> {
//jpa repositity bhi extend kar sakte
}
