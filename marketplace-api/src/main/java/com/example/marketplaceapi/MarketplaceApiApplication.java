package com.example.marketplaceapi;

import com.example.marketplaceapi.database.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketplaceApiApplication implements CommandLineRunner {
	// collections and variables
	public UserRepository userRepository;

	@Autowired
	void AppApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}







	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApiApplication.class, args);
	}


	public void run(String... args) throws Exception{
		for(User user : userRepository.findAll()){
			System.out.println(user.toString());
		}
	}

}
