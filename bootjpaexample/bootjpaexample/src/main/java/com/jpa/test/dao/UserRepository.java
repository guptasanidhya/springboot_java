package com.jpa.test.dao;

import com.jpa.test.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<User,Integer> {
//jpa repositity bhi extend kar sakte

//    public List<User> findByName(String name);
//    public List<User> findByNameAndCity(String name,String City);
//    public List<User> findByNameStartingWith(String name);
//    public List<User> findByNameEndingWith(String name);
//    public List<User> findByNameLike(String name);
//    public List<User> findByNameContaining(String name);

    @Query("select u FROM User u")
    public List<User> getAllUser();

    //ye jo n likha hai query m last me isse param ko map karna tab wo bind ho paega
    @Query("select u from User u where u.name=:n" )
    public List<User> getUserByName( @Param("n") String name);

    @Query(value="select * from user", nativeQuery = true)
    public List<User> getUsers();

}
