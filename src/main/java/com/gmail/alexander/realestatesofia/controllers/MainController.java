package com.gmail.alexander.realestatesofia.controllers;

import com.gmail.alexander.realestatesofia.models.abstracts.Customer;
import com.gmail.alexander.realestatesofia.models.abstracts.Property;
import com.gmail.alexander.realestatesofia.models.concrete.Agency;
import com.gmail.alexander.realestatesofia.models.concrete.Employee;
import com.gmail.alexander.realestatesofia.models.costumers.Buyer;
import com.gmail.alexander.realestatesofia.models.costumers.Seller;
import com.gmail.alexander.realestatesofia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @ResponseBody
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
    @ResponseBody
    public Agency registrationAgencyDone(@ModelAttribute Agency agency, Model model) {
        agencyDAO.insert(agency);
        model.addAttribute("name", agency.getName());
        Agency record =agencyDAO.findTopByOrderByIdDesc();
        return record;
    }

    /**
     * Shows all agencies that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */
    @RequestMapping(value = "/showAgencies", method = RequestMethod.GET)
    @ResponseBody
    public List<Agency> showAgencies(Model model) {
        List<Agency> agencies = agencyDAO.findAll();
        model.addAttribute("agencies", agencies);
        return agencies;
    }

    /**
     * Shows all employees that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */
    @RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> showEmployees(Model model) {
        List<Employee> employees = employeeDAO.findAll();
        model.addAttribute("employees", employees);
        return employees;
    }

    /**
     * Shows all customers that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> showCustomers(Model model) {
        List<Customer> customers = customerDAO.findAll();
        model.addAttribute("customers", customers);
        return customers;
    }

    /**
     * Shows all sellers that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showSellers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> showSellers(@RequestParam(required = false) Integer id, Model model) {
        List<Customer> sellers = new ArrayList<>();
        if (id == null) {
            sellers.addAll(sellerDAO.findAll());
        } else {
            sellers.addAll(sellerDAO.findBuyersByEmployeeId(id));
        }
        model.addAttribute("sellers", sellers);
        return sellers;
    }

    /**
     * Shows all buyers that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showBuyers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> showBuyers(@RequestParam(required = false) Integer id, Model model) {
        List<Customer> buyers = new ArrayList<>();
        if (id == null) {
            buyers.addAll(buyerDAO.findAll());
        } else {
            buyers.addAll(buyerDAO.findBuyersByEmployeeId(id));
        }
        model.addAttribute("buyers", buyers);
        return buyers;
    }

    /**
     * Shows all properties that are in the database.
     *
     * @param model is used to send to the page collection of objects for display yo user.
     * @return name of the page that will display information to user.
     */

    @RequestMapping(value = "/showProperties", method = RequestMethod.GET)
    @ResponseBody
    public List<Property> showProperties(Model model) {
        List<Property> properties = propertyDAO.findAll();
        model.addAttribute("properties", properties);
        return properties;
    }
}
