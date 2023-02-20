package com.example.marketplaceapi;

import com.example.marketplaceapi.database.*;
import com.example.marketplaceapi.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketplaceApiApplication implements CommandLineRunner {
	// collections and variables
	public UserRepository userRepository;
	public ActiveListingRepository activeListingRepository;
	public CompletedListingRepository completedListingRepository;

	public static UserRepository visableUserRepo;
	public static ActiveListingRepository visableActiveListingRepo;
	public static CompletedListingRepository visableCompletedListingRepo;


	@Autowired
	void AppApplication(UserRepository userRepository, ActiveListingRepository activeListingRepository, CompletedListingRepository completedListingRepository){
		this.userRepository = userRepository;
		this.activeListingRepository = activeListingRepository;
		this.completedListingRepository = completedListingRepository;
	}







	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApiApplication.class, args);
	}


	public void run(String... args) throws Exception{
		// initialize visable collecitons
		visableUserRepo = userRepository;
		visableActiveListingRepo = activeListingRepository;
		visableCompletedListingRepo = completedListingRepository;



		System.out.println("Users: ");
		for(User user : userRepository.findAll()){
			System.out.print(user.toString());
		}

		System.out.println();
		System.out.println("Active Listings: ");
		for (ActiveListing activeListing : activeListingRepository.findAll()){
			System.out.print(activeListing.toString());
		}

		System.out.println();
		System.out.println("Completed Listings: ");
		for (CompletedListing completedListing : completedListingRepository.findAll()){
			System.out.print(completedListing.toString());
		}
		System.out.println();
	}

}
