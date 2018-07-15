package com.gmail.alexander.realestatesofia;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.concrete.ViewedRealEstate;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import com.gmail.alexander.realestatesofia.entity.realesates.Apartment;
import com.gmail.alexander.realestatesofia.entity.realesates.House;
import com.gmail.alexander.realestatesofia.entity.realesates.Land;
import com.gmail.alexander.realestatesofia.entity.types.*;
import com.gmail.alexander.realestatesofia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.List;

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
    @Autowired
    private HouseDAO houseDAO;
    @Autowired
    private LandDAO landDAO;
    @Autowired
    private ViewedRealEstateDAO viewedRealEstateDAO;

    public static void main(String[] args) {
        SpringApplication.run(RealEstateSofiaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//TODO This is some test data
        Agency agency = new Agency();
        agency.setName("Sofia Real Estate Agency");
        agency.setAddress("Sofia, Sofia Street number 1");
        agency.setPhone("+35941234734345");
        agencyDAO.insert(agency);
        agencyDAO.insert(agency);
        agencyDAO.insert(agency);
        agencyDAO.insert(agency);
        System.out.println("Agency:");
        Agency expectedAgecy = agencyDAO.findById(1);
        System.out.println("Agency: " + expectedAgecy.getId() + expectedAgecy.getName() + expectedAgecy.getAddress());

        Employee employee1 = new Employee();
        employee1.setName("Иван Служителя");
        employee1.setPhone("+359909090");
        employee1.setAgency(agency);
        employeeDAO.insert(employee1);
        employeeDAO.insert(employee1);
        employeeDAO.insert(employee1);
        employeeDAO.insert(employee1);
        employeeDAO.insert(employee1);

        Employee expectedEmproyee = employeeDAO.findById(1);
        System.out.println("Employee: " + expectedEmproyee.getId() + expectedEmproyee.getName() + expectedEmproyee.getPhone());

        for (int i = 1; i < 10; i++) {
            Customer customer = new Customer();
            customer.setName("Иван Клиента Продавач" + i);
            customer.setPhone("34912312" + i);
            customerDAO.insert(customer);
            Customer expectedCustomer = customerDAO.findById(i);
            System.out.println("Customer: " + expectedCustomer.getPhone() + expectedCustomer.getName() + expectedCustomer.getId());
            Seller seller = new Seller();
            seller.setPhone("34912312" + i);
            sellerDAO.insert(seller);
            Customer customer2 = new Customer();
            customer2.setName("Иван Клиента Купувач" + i);
            customer2.setPhone("34912313" + i);
            customerDAO.insert(customer2);

            Buyer buyer = new Buyer();
            buyer.setBudget(10000.00);
            buyer.setPhone("34912313" + i);
            buyerDAO.insert(buyer);

            Property property = new Property();
            property.setAddress("Some Address");
            property.setDescription("Some KInd of description.");
            property.setRealEstateType(RealEstateType.type.get("APARTMENT"));
            property.setPrice(19999.00);
            property.setSizeOfRealEstate(200);
            property.setSeller(seller);
            propertyDAO.insert(property);
            propertyDAO.insert(property);
            propertyDAO.insert(property);
            propertyDAO.insert(property);
            propertyDAO.insert(property);
            property.setAddress("Продаден апартамент!");
            property.setSold(true);
            propertyDAO.insert(property);
        }
            Property expectedPropertyAsApartment = propertyDAO.findById(1);

            Apartment apartment = new Apartment();
            apartment.setId(expectedPropertyAsApartment.getId());
            apartment.setBuildMaterial(BuildMaterial.type.get("BRICK"));
            apartment.setApartmentType(ApartmentType.type.get("STUDIO"));
            apartmentDAO.insert(apartment);
            Property property2= propertyDAO.findById(2);
            House house = new House();
            house.setId(property2.getId());
            house.setParkingSpace(2);
            house.setHouseType(HouseType.type.get("HOUSE"));
            house.setBuildMaterial(BuildMaterial.type.get("BRICK"));
            house.setYardSize(200);
            houseDAO.insert(house);

            Land land = new Land();
            Property property3 = propertyDAO.findById(3);
            land.setId(property3.getId());
            land.setRegulated(true);
            land.setLandType(LandType.type.get("LAWN"));
            landDAO.insert(land);

            List<Agency> agencies = agencyDAO.findAll();
            for (Agency each : agencies
                    ) {
                System.out.println("Each Agency: " + each.getName());
            }

            List<Employee> employees = employeeDAO.findAll();
            for (Employee each : employees
                    ) {
                System.out.println("Each employee: " + each.getName());
            }

            List<Customer> customers = customerDAO.findAll();
            for (Customer each : customers) {
                System.out.println("Each customer: " + each.getName());
            }

            List<Buyer> buyers = buyerDAO.findAll();
            for (Buyer each :
                    buyers) {
                System.out.println("Each buyer: " + each.getName());
            }

            List<Seller> sellers = sellerDAO.findAll();

            for (Seller each : sellers
                    ) {
                System.out.println("Each seller: " + each.getName());
            }

            List<Property> properties = propertyDAO.findAll();
            for (Property each :
                    properties) {
                System.out.println("Each Property: " + each.getAddress());
            }

            List<Apartment> apartments = apartmentDAO.findAll();
            for (Apartment each : apartments
                    ) {
                System.out.println("Each Apartment: " + each.getAddress());
            }
            List<House> houses = houseDAO.findAll();
            for (House each : houses
                    ) {
                System.out.println("Each House: " + each.getAddress());
            }

            List<Land> lands = landDAO.findAll();
            for (Land each : lands) {
                System.out.println("Each Land: " + each.getAddress());
            }

    }
}

