package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.types.AparmentType;
import com.gmail.alexander.realestatesofia.entity.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.entity.types.RealEstateType;
import com.gmail.alexander.realestatesofia.repository.AgencyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateSofiaApplication implements CommandLineRunner {
@Autowired
private AgencyDAO agencyDAO;
    public static void main(String[] args) {
        SpringApplication.run(RealEstateSofiaApplication.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
       /* Agency agency = new Agency();
        agency.setId(1L);
        agency.setName("New Agency");
        agency.setAddress("some kind of address");
        agency.setContactByPhone("+35941234734345");

        agencyDAO.insert(agency);
        Agency expected  = agencyDAO.findById(1);
        System.out.println("Expected agency: "+expected.getName());
        expected.setAddress("new adress");
        expected.setName("new name");
        agencyDAO.update(expected);
        Agency updated = agencyDAO.findById(1);

        System.out.println("After update: " + updated.getName() );
 */   }
}
