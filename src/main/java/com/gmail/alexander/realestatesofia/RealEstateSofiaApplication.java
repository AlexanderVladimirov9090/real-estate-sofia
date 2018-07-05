package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.concrete.Buyer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateSofiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateSofiaApplication.class, args);
		Customer customer = new Buyer(1L,"Mr.Buyer","+3456435",Buyer.class);

		System.out.println(customer.getType());
	}

}
