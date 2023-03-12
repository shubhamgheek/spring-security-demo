package com.shubham.SpringSecurityDemo;

import com.shubham.SpringSecurityDemo.entities.User;
import com.shubham.SpringSecurityDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Shubham", "$2a$10$NcMHK9EFHxGZPEfv.YrGIuMYtALnKWAvHT.nF7lQmMEdezr859eee", "adminRole", Boolean.TRUE, "admin:student", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
		User user1 = new User("Rahul", "$2a$10$87k9WD8v2QvPoPi/t2uyzuV0IY0i3IR.BVAR1CcQvtGT53aeb.ZWK", "studentRole", Boolean.TRUE, "student", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);

		userRepository.save(user);
		userRepository.save(user1);
	}
}
