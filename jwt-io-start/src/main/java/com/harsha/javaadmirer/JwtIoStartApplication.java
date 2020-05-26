package com.harsha.javaadmirer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import com.harsha.javaadmirer.entity.User;
import com.harsha.javaadmirer.repository.UserRepository;

@SpringBootApplication
public class JwtIoStartApplication {

	@Autowired
	private UserRepository userRepo;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(101, "javaadrmirer", "password", "javaadmirer@gmail.com"),
				new User(102, "javatechie", "password", "javatechie@gmail.com"),
				new User(103, "javabrains", "password", "javabrains@gmail.com"),
				new User(104, "java4s", "password", "java4s@gmail.com")).collect(Collectors.toList());
		System.out.println(users);
		userRepo.saveAll(users);
	}
	
	@GetMapping("/getUsers")
	public void getUsers() {		
		userRepo.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtIoStartApplication.class, args);
	}

}
