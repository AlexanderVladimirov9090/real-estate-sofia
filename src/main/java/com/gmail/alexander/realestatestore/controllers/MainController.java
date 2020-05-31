package com.gmail.alexander.realestatestore.controllers;

import com.gmail.alexander.realestatestore.models.abstracts.Customer;
import com.gmail.alexander.realestatestore.models.abstracts.Property;
import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.models.concrete.Employee;
import com.gmail.alexander.realestatestore.models.costumers.Buyer;
import com.gmail.alexander.realestatestore.models.costumers.Seller;
import com.gmail.alexander.realestatestore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * Main controller used to send RESTful responses.
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
     * This will register Employee
     *
     * @param employee this is the object that is send by the browser. Uses JSON format.
     * @param model    is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */
    @RequestMapping(value = "/registerEmployee", method = RequestMethod.POST)
    public List<Employee> registrationEmployee(@ModelAttribute Employee employee, Model model) {
        employeeDAO.insert(employee);
        model.addAttribute("name", employee.getName());
        Employee lastEmployee = employeeDAO.findTopByOrderByIdDesc();
        return new LinkedList<Employee>() {{
            add(lastEmployee);
        }};
    }

    /**
     * This will register Customer
     *
     * @param customer this is the object that is send by the browser. Uses JSON format.
     * @param model    is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public List<Customer> registrationCustomer(@ModelAttribute Customer customer, Model model) {
        customerDAO.insert(customer);
        Customer lastCustomer= customerDAO.findTopByOrderByIdDesc();
        return new LinkedList<Customer>() {{
            add(lastCustomer);
        }};
    }

    /**
     * This will register Buyer
     *
     * @param buyer this is the object that is send by the browser. Uses JSON format.
     * @param model is used to store the name of the employee to confirm inserting record.
     * @return name of the page that will be loaded next.
     */
    @RequestMapping(value = "/registerBuyer", method = RequestMethod.POST)
    public List<Customer> registrationBuyer(@ModelAttribute Buyer buyer, Model model) {
        buyerDAO.insert(buyer);
        Customer lastBuyer = buyerDAO.findTopByOrderByIdDesc();
        return new LinkedList<Customer>() {{
            add(lastBuyer);
        }};
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
    public List<Customer> registrationSeller(@ModelAttribute Seller seller, Model model) {
        sellerDAO.insert(seller);
        Customer lastSeller = sellerDAO.findTopByOrderByIdDesc();
        return new LinkedList<Customer>() {{
            add(lastSeller);
        }};
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
    public List<Agency> registrationAgency(@ModelAttribute Agency agency, Model model) {
        agencyDAO.insert(agency);
        Agency lastAgency = agencyDAO.findTopByOrderByIdDesc();
        return new LinkedList<Agency>() {{
            add(lastAgency);
        }};
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
        return properties;
    }
}
