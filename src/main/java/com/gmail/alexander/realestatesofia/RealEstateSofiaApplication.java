package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.models.abstracts.Properties;
import com.gmail.alexander.realestatesofia.models.realesates.Apartment;
import com.gmail.alexander.realestatesofia.models.types.AparmentType;
import com.gmail.alexander.realestatesofia.models.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.models.types.RealEstateType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateSofiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealEstateSofiaApplication.class, args);
        Properties aparment = new Apartment(1L,123,"None","None",1000,RealEstateType.APARTMENT,null,BuildMaterial.BRICK,AparmentType.GARSONIERA);
    }

}
