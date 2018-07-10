package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.types.ApartmentType;
import com.gmail.alexander.realestatesofia.entity.types.BuildMaterial;
import com.gmail.alexander.realestatesofia.entity.types.RealEstateType;
import com.gmail.alexander.realestatesofia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateSofiaApplication implements CommandLineRunner {
@Autowired
private AgencyDAO agencyDAO;
@Autowired
private ApartmentDAO apartmentDAO;
@Autowired
private EmployeeDAO employeeDAO;
@Autowired
private SellerDAO sellerDAO;
@Autowired
private CustomerDAO customerDAO;
@Autowired
private BuyerDAO buyerDAO;
@Autowired
private PropertyDAO propertyDAO;

    public static void main(String[] args) {
        SpringApplication.run(RealEstateSofiaApplication.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
//TODO This is the registration section
        Agency agency = new Agency();
        agency.setId(1);
        agency.setName("Sofia Real Estate Agency");
        agency.setAddress("Sofia, Sofia Street number 1");
        agency.setContactByPhone("+35941234734345");
        agencyDAO.insert(agency);

        Employee employee1= new Employee();
        employee1.setId(1);
        employee1.setName("Ivan Ivanov aka. Vankata");
        employee1.setPhone("+359909090");
        employee1.setAgency(agency);
        employeeDAO.insert(employee1);



        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setPhone("+349123123123");
        customer.setId(1);
        customerDAO.insert(customer);
        Seller seller = new Seller();
        seller.setId(customer.getId());
        sellerDAO.insert(seller);
        Seller expectedSeller = sellerDAO.findById(1);
        System.out.println("seller`s name: "+ expectedSeller.getName());
        Buyer buyer = new Buyer();
        buyer.setBudget(10000.00);
        buyer.setId(1);
        buyerDAO.insert(buyer);

        Property property = new Property();
        property.setId(1);
        property.setAddress("Some Address");
        property.setDescription("Some KInd of description.");
        property.setRealEstateType(RealEstateType.realEstateType.get("APARTMENT"));
        property.setPrice(19999.00);
        property.setSizeOfRealEstate(200);
        Seller sellerOfAparment = sellerDAO.findById(1);
        property.setSeller(sellerOfAparment);

        propertyDAO.insert(property);
        Apartment apartment = new Apartment();
        apartment.setId(1);
        apartment.setBuildMaterial(BuildMaterial.type.get("BRICK"));
        apartment.setApartmentType(ApartmentType.type.get("STUDIO"));
        apartmentDAO.insert(apartment);


   /*  Agency expected  = agencyDAO.findById(1);
        System.out.println("Expected agency: "+expected.getName());


        Employee expectedEmployee = employeeDAO.findById(1);
        System.out.println("Expected employee: "+ expectedEmployee.getName()+ "Agency: " + expected.getName());


*/
/*

        Apartment apartment= new Apartment();
        apartment.setId(1);
        apartment.setAddress("SOme Address");
        apartment.setDescription("SOme Description");
        apartment.setPrice(199999.00);
        apartment.setRealEstateType(RealEstateType.realEstateType.get("APARTMENT"));
        apartment.setSizeOfRealEstate(999);
        apartment.setApartmentType(ApartmentType.type.get("STUDIO"));
        apartment.setBuildMaterial(BuildMaterial.type.get("BRICK"));
        apartment.setEmployee(expectedEmployee);*//*
        apartment.setSeller();*//*
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
*/
    }
}
