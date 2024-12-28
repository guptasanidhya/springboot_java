package com.jpa.test;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
//			User user = new User();
//			user.setName("Sanidhya");
//			user.setCity("Indore");
//			user.setStatus("I am a programmer");
//			User user1 = userRepository.save(user);
//			System.out.println(user1);

//		User user1 = new User();
//		user1.setName("Sanidhya");
//			user1.setCity("Indore");
//			user1.setStatus("I am a programmer");
////
//		User user2 = new User();
//		user2.setName("Sanidhya");
//			user2.setCity("Indore");
//			user2.setStatus("I am a programmer");
//
//		List<User> users = List.of(user1,user2);
//		Iterable<User> result=userRepository.saveAll(users);
//
//		result.forEach(user->{
//			System.out.println(user);
//		});


		//update the user of id 2
//		Optional<User> optional =  userRepository.findById(2);
//		User user = optional.get();
//		user.setName("Gopi");
//		User result = userRepository.save(user);
//		System.out.println(result);

//		get the data
//				Optional<User> optional =  userRepository.findById(2);
//		User user = optional.get();

//		Iterable<User> itr = userRepository.findAll();
//		Iterator<User> iterator = itr.iterator();
//		while(iterator.hasNext()){
//			User user = iterator.next();
//			System.out.println(user);
//		}

		//enhanced
//		for (User user : itr) {
//			System.out.println(user);
//		}
//
//		System.out.println("Done with creation");


		//delete user

//		userRepository.deleteById(5);
//		System.out.println("deleted");
//		Iterable<User> itr1 = userRepository.findAll();
//		for (User user : itr1) {
//			System.out.println(user);
//		}

//		List<User> list = userRepository.findByName("Sanidhya");
//		List<User> list = userRepository.findByNameAndCity("Gopi","Indore");
//		List<User> list = userRepository.findByNameContaining("an");
//		List<User> list = userRepository.getAllUser();
		List<User> list = userRepository.getUsers();
		List<User> list1 = userRepository.getUserByName("Gopi");




		for(User user : list){
			System.out.println(user);
		}
		System.out.println("-----------------------------------------------------------------");


		for(User user : list1){
			System.out.println(user);
		}

	}

}
