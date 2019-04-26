package com.hcl.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByemail(String email);

}
