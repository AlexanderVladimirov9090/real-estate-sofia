package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.abstracts.RealEstate;
import com.gmail.alexander.realestatesofia.models.concrete.Buyer;
import com.gmail.alexander.realestatesofia.models.concrete.House;
import com.gmail.alexander.realestatesofia.models.concrete.RealEstateAgent;
import com.gmail.alexander.realestatesofia.models.types.HouseType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class RealEstateSofiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateSofiaApplication.class, args);
		List<RealEstate> visitedEstates= new LinkedList<RealEstate>();
		visitedEstates.add(new House(1L,20,"Some description","Some address",200,HouseType.HOUSE, new RealEstateAgent(1L,null,null,null,null,null,null)));
		Customer customer = new Buyer(1L,"Mr.Buyer","+3456435",Buyer.class,500000,visitedEstates);

		System.out.println(customer.getType());
	}

}
