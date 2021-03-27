package com.example.springTransactional;

import com.example.springTransactional.model.User;
//import com.example.springTransactional.service.UserService;
import com.example.springTransactional.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringTransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionalApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserService userService) throws Exception {

		return (String[] args) -> {
			User user1 = new User("John", "john@domain.com");
			userService.createUser(user1);

			User user2 = new User("Julie", "julie@domain.com");
			userService.createUser(user2);

			for (User user: userService.getAllUsers()){
				System.out.println(user);
			}

			userService.deleteUser(user1);
			for (User user: userService.getAllUsers()){
				System.out.println(user);
			}
		};
	}

}
