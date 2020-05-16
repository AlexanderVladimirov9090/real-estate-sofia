package com.gmail.alexander.realestatesofia.controllers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.abstracts.Property;
import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import com.gmail.alexander.realestatesofia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 11.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This class is the main controller and mapper to the html.
 * Gets data from DAO and passes it to the VIEW.
 * View has a hidden logic where populates the HTML page.
 */
//Tells the framework that This is controller
@Controller
public class MainController {
    //This annotation is to instantiate object using reflection.
    @Autowired
    private AgencyDAO agencyDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BuyerDAO buyerDAO;
    @Autowired
    private SellerDAO sellerDAO;
    @Autowired
    private PropertyDAO propertyDAO;


    /**
     * This annotation is used to map address to functionality.
     * When type localhost:8080 it will load index page.
     *
     * @return the name of the web page that will be loaded.
     */
    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    /**
     * This will load Agency registering page.
     *
     * @return
     */
    // Annotation is used to tell the framework that page will be loaded using GET METHOD.
    @GetMapping("/registerAgency")
    public String registerAgency() {
        return "registrationAgency";
    }

    /**
     * This will load Employee registering page.
     *
     * @return
     */
    @GetMapping("/registerEmployee")
    public String registerEmployee() {
        return "registrationEmployee";
    }

    /**
     * This will load Customer registering page.
     *
     * @return
     */
    @GetMapping("/registerCustomer")
    public String registerCustomer() {
        return "registrationCustomer";
    }

    /**
     * This will load Buyer registering page.
     *
     * @return
     */

    @GetMapping("/registerBuyer")
    public String registerBuyer(Model model) {
        return "registrationBuyer";
    }

    /**
     * This will load Seller registering page.
     *
     * @return
     */

    @GetMapping("/registerSeller")
    public String registerSeller(Model model) {
        return "registrationSeller";
    }

    /**
     * This will load Property registering page.
     *
     * @return
     */
    @GetMapping("/registerProperty")
    public String registerProperty(Model model) {
        return "registrationProperty";
    }

    /**
     * This will register Employee
     *
     * @param employee this is the object that is send by the browser. Uses JSON format.
     * @param model    is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */
    @RequestMapping(value = "/registerEmployee", method = RequestMethod.POST)
    public String registrationEmployeeDone(@ModelAttribute Employee employee, Model model) {
        employeeDAO.insert(employee);
        model.addAttribute("name", employee.getName());
        return "employee";
    }

    /**
     * This will register Customer
     *
     * @param customer this is the object that is send by the browser. Uses JSON format.
     * @param model    is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public String registrationCustomerDone(@ModelAttribute Customer customer, Model model) {
        customerDAO.insert(customer);
        model.addAttribute("name", customer.getName());
        return "customer";
    }

    /**
     * This will register Buyer
     *
     * @param buyer this is the object that is send by the browser. Uses JSON format.
     * @param model is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */
    @RequestMapping(value = "/registerBuyer", method = RequestMethod.POST)
    public String registrationBuyerDone(@ModelAttribute Buyer buyer, Model model) {
        buyerDAO.insert(buyer);
        model.addAttribute("name", buyer.getPhone());
        return "buyer";
    }

    /**
     * This will register Seller
     *
     * @param seller this is the object that is send by the browser. Uses JSON format.
     * @param model  is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */
    @RequestMapping(value = "/registerSeller", method = RequestMethod.POST)
    public String registrationSellerDone(@ModelAttribute Seller seller, Model model) {
        sellerDAO.insert(seller);
        model.addAttribute("name", seller.getPhone());
        return "seller";
    }

    /**
     * This will register Agency
     *
     * @param agency this is the object that is send by the browser. Uses JSON format.
     * @param model  is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */

    @RequestMapping(value = "/registerAgency", method = RequestMethod.POST)
    public String registrationAgancyDone(@ModelAttribute Agency agency, Model model) {
        agencyDAO.insert(agency);
        model.addAttribute("name", agency.getName());
        return "agency";
    }

    /**
     * Shows all agencies that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */
    @RequestMapping(value = "/showAgencies", method = RequestMethod.GET)
    public String showAgencies(Model model) {
        List<Agency> agencies = agencyDAO.findAll();
        model.addAttribute("agencies", agencies);
        return "showAgencies";
    }

    /**
     * Shows all employees that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */
    @RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
    public String showEmployees(Model model) {
        List<Employee> employees = employeeDAO.findAll();
        model.addAttribute("employees", employees);
        return "showEmployees";
    }
    /**
     * Shows all customers that are in the database.
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
    public String showCustomers(Model model) {
        List<Customer> customers = customerDAO.findAll();
        model.addAttribute("customers", customers);
        return "showCustomers";
    }
    /**
     * Shows all sellers that are in the database.
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showSellers", method = RequestMethod.GET)
    public String showSellers(@RequestParam(required = false) int id, Model model) {

        List<Seller> sellers = sellerDAO.findAll();
        if(id==0) {
            sellers = sellerDAO.findAll();
        }
        else {
            sellers= sellerDAO.findBuyersByEmployeeId(id);
        }
        model.addAttribute("sellers", sellers);
        return "showSellers";
    }
    /**
     * Shows all buyers that are in the database.
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showBuyers", method = RequestMethod.GET)
    public String showBuyers(@RequestParam(required = false) int id, Model model) {
        List<Buyer> buyers;
        if(id==0) {
            buyers = buyerDAO.findAll();
        }
        else {
                buyers = buyerDAO.findBuyersByEmployeeId(id);
        }
        model.addAttribute("buyers", buyers);

        return "showBuyers";
    }
    /**
     * Shows all properties that are in the database.
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showProperties", method = RequestMethod.GET)
    public String showProperties(Model model) {
        List<Property> properties = propertyDAO.findAll();
        model.addAttribute("properties", properties);
        return "showProperties";
    }
}
