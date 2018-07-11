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
//TODO This is the registration section
        Agency agency = new Agency();
        agency.setId(1);
        agency.setName("Sofia Real Estate Agency");
        agency.setAddress("Sofia, Sofia Street number 1");
        agency.setContactByPhone("+35941234734345");
        agencyDAO.insert(agency);
        System.out.println("Agency:");
        Agency expectedAgecy = agencyDAO.findById(1);
        System.out.println("Agency: " + expectedAgecy.getId() + expectedAgecy.getName() + expectedAgecy.getAddress());

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Ivan Ivanov aka. Vankata");
        employee1.setPhone("+359909090");
        employee1.setAgency(agency);
        employeeDAO.insert(employee1);
        Employee expectedEmproyee = employeeDAO.findById(1);
        System.out.println("Employee: " + expectedEmproyee.getId() + expectedEmproyee.getName() + expectedEmproyee.getPhone());

        Customer customer = new Customer();
        customer.setName("Ivan");
        customer.setPhone("+349123123123");
        customer.setId(1);
        customerDAO.insert(customer);
        Customer expectedCustomer = customerDAO.findById(1);
        System.out.println("Customer: " + expectedCustomer.getPhone() + expectedCustomer.getName() + expectedCustomer.getId());
        Seller seller = new Seller();
        seller.setId(customer.getId());
        sellerDAO.insert(seller);
        Seller expectedSeller = sellerDAO.findById(1);
        System.out.println("Seller: " + expectedSeller.getId() + expectedSeller.getName() + expectedSeller.getPhone());
        Buyer buyer = new Buyer();
        buyer.setBudget(10000.00);
        buyer.setId(1);
        buyerDAO.insert(buyer);
        Buyer expectedBuyer = buyerDAO.findById(1);
        System.out.println("Buyer: " + expectedBuyer.getId() + expectedBuyer.getName() + expectedBuyer.getPhone() + expectedBuyer.getBudget());
        Property property = new Property();
        property.setId(1);
        property.setAddress("Some Address");
        property.setDescription("Some KInd of description.");
        property.setRealEstateType(RealEstateType.realEstateType.get("APARTMENT"));
        property.setPrice(19999.00);
        property.setSizeOfRealEstate(200);
        property.setSeller(expectedSeller);
        propertyDAO.insert(property);
        Property expectedProperty = propertyDAO.findById(1);
        System.out.println("Property: " + expectedProperty.getId() + expectedProperty.getRealEstateType() + expectedProperty.getDescription() + expectedProperty.getPrice() + expectedProperty.getAddress() + expectedProperty.getSizeOfRealEstate() + expectedProperty.isSold());
        Apartment apartment = new Apartment();
        apartment.setId(1);
        apartment.setBuildMaterial(BuildMaterial.type.get("BRICK"));
        apartment.setApartmentType(ApartmentType.type.get("STUDIO"));
        apartmentDAO.insert(apartment);
        Apartment expectedApartment = apartmentDAO.findById(1);
        System.out.println("Apartment: " + expectedApartment.getId() + expectedApartment.getRealEstateType() + expectedApartment.getDescription() + expectedApartment.getPrice() + expectedApartment.getAddress() + expectedApartment.getSizeOfRealEstate() + expectedApartment.getBuildMaterial() + expectedApartment.getApartmentType() + expectedApartment.isSold());
        House house = new House();
        house.setId(1);
        house.setParkingSpace(2);
        house.setHouseType(HouseType.houseType.get("HOUSE"));
        house.setBuildMaterial(BuildMaterial.type.get("BRICK"));
        house.setYardSize(200);
        houseDAO.insert(house);
        House expectedHouse = houseDAO.findById(1);
        System.out.println("House: " + expectedHouse.getId() + expectedHouse.getRealEstateType() + expectedHouse.getDescription() + expectedHouse.getPrice() + expectedHouse.getAddress() + expectedHouse.getSizeOfRealEstate() + expectedHouse.getBuildMaterial() + expectedHouse.getHouseType() + expectedHouse.isSold() + expectedHouse.getYardSize() + expectedHouse.getBuildMaterial() + expectedHouse.getParkingSpace());

        Land land = new Land();
        land.setId(1);
        land.setRegulated(true);
        land.setLandType(LandType.landType.get("LAWN"));
        landDAO.insert(land);
        Land expectedLand = landDAO.findById(1);
        System.out.println("Land:" + expectedLand.getId() + expectedLand.getRealEstateType() + expectedLand.getDescription() + expectedLand.getPrice() + expectedLand.getAddress() + expectedLand.getSizeOfRealEstate() + expectedLand.getLandType() + expectedLand.isSold());

        ViewedRealEstate viewedRealEstate = new ViewedRealEstate();
        viewedRealEstate.setId(1);
        viewedRealEstate.setBuyers(buyer);
        viewedRealEstate.setPropertyForView(property);
        viewedRealEstate.setRealEstateViewingDate(new Timestamp(System.currentTimeMillis()));
        viewedRealEstateDAO.insert(viewedRealEstate);
        ViewedRealEstate expectedViewedRealEstate = viewedRealEstateDAO.findById(1);
        System.out.println("ViewedRealEstate: " + expectedViewedRealEstate.getId() + expectedViewedRealEstate.getRealEstateViewingDate().toString());

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
            System.out.println("Each buyer: "+ each.getName());
        }

        List<Seller> sellers = sellerDAO.findAll();

        for (Seller each:sellers
             ) {
            System.out.println("Each seller: " + each.getName());
        }

        List<Property>    properties = propertyDAO.findAll();
        for (Property each:
             properties) {
            System.out.println("Each Property: "+ each.getAddress());
        }

        List<Apartment> apartments = apartmentDAO.findAll();
        for (Apartment each: apartments
             ) {
            System.out.println("Each Apartment: " +each.getAddress());
        }
        List<House> houses = houseDAO.findAll();
        for (House each: houses
             ) {
            System.out.println("Each House: "+ each.getAddress());
        }

        List<Land> lands = landDAO.findAll();
        for (Land each : lands){
            System.out.println("Each Land: " + each.getAddress());
        }
    }
}
