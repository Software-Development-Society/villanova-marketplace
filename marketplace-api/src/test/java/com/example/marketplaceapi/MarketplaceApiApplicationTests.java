package com.example.marketplaceapi;

import com.example.marketplaceapi.services.DatabaseServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarketplaceApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAllUsers(){
		DatabaseServices dBServices = new DatabaseServices();
	}

}
