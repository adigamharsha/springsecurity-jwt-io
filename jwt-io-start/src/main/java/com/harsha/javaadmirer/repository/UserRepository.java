package com.harsha.javaadmirer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsha.javaadmirer.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 User findByUserName(String username);

}
