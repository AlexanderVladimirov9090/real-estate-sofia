package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.types.ApartmentType;
import com.gmail.alexander.realestatesofia.entity.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.entity.types.RealEstateType;
import com.gmail.alexander.realestatesofia.repository.AgencyDAO;
import com.gmail.alexander.realestatesofia.repository.ApartmentDAO;
import com.gmail.alexander.realestatesofia.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RealEstateSofiaApplication implements CommandLineRunner {
@Autowired
private AgencyDAO agencyDAO;
@Autowired
private ApartmentDAO apartmentDAO;
@Autowired
private EmployeeDAO employeeDAO;
    public static void main(String[] args) {
        SpringApplication.run(RealEstateSofiaApplication.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
        Agency agency = new Agency();
        agency.setId(1);
        agency.setName("Sofia Real Estate Agency");
        agency.setAddress("Sofia, Sofia Street number 1");
        agency.setContactByPhone("+35941234734345");

        agencyDAO.insert(agency);
        Agency expected  = agencyDAO.findById(1);
        System.out.println("Expected agency: "+expected.getName());
        Employee employee1= new Employee();
        employee1.setId(1);
        employee1.setName("Ivan Ivanov aka. Vankata");
        employee1.setPhone("+359909090");
        employee1.setAddress("Home street 1");
        employeeDAO.insert(employee1);

        Employee expectedEmployee = employeeDAO.findById(1);
        System.out.println("Expected employee: "+ expectedEmployee.getName()+ "Agency: " + expected.getName());





        Apartment apartment= new Apartment();
        apartment.setId(1);
        apartment.setAddress("SOme Address");
        apartment.setDescription("SOme Description");
        apartment.setPrice(199999.00);
        apartment.setRealEstateType(RealEstateType.realEstateType.get("APARTMENT"));
        apartment.setSizeOfRealEstate(999);
        apartment.setApartmentType(ApartmentType.type.get("STUDIO"));
        apartment.setBuildMaterial(BuildMaterial.builMaterialType.get("BRICK"));
        apartment.setEmployee(expectedEmployee);
        apartmentDAO.deleteById(1);
        apartmentDAO.insert(apartment);

        System.out.println(apartmentDAO.findAll().size());
       System.out.println("aster update: " + apartmentDAO.findById(1).getAddress());
    apartment.setAddress("New Aparament ADdress");
    apartment.setId(2);
    apartment.setEmployee(employee1);
    apartment.setPrice(199.00);
    apartmentDAO.insert(apartment);
        List<Apartment> apartments = apartmentDAO.findAll();
        for (Apartment each:apartments) {
            System.out.println(each.getAddress()+ " "+each.getPrice() +" " + each.getEmployee().getName());

        }







    }
}
