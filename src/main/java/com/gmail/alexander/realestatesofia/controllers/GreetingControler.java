package com.gmail.alexander.realestatesofia.controllers;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import com.gmail.alexander.realestatesofia.entity.concrete.Agency;
import com.gmail.alexander.realestatesofia.entity.concrete.Employee;
import com.gmail.alexander.realestatesofia.entity.costumers.Buyer;
import com.gmail.alexander.realestatesofia.entity.costumers.Seller;
import com.gmail.alexander.realestatesofia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created on 11.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Controller
public class GreetingControler {
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

    @GetMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    @GetMapping("/registerAgency")
    public String registerAgency(Model model) {
        return "registrationAgency";
    }

    @RequestMapping(value = "/showAgencies", method = RequestMethod.GET)
    public String showAgencies(Model model) {
        List<Agency> agencies = agencyDAO.findAll();

        for (Agency each : agencies) {
            System.out.println("Each Agency: " + each.getName());
        }
        model.addAttribute("agencies",agencies);
        return "showAgencies";
    }
    @RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
    public String showEmployees(Model model) {
        List<Employee> employees = employeeDAO.findAll();

        for (Employee each : employees) {
            System.out.println("Each Agency: " + each.getName());
        }
        model.addAttribute("employees",employees);
        return "showEmployees";
    }
    @RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
    public String showCustomers(Model model) {
        List<Customer> customers = customerDAO.findAll();


        model.addAttribute("customers",customers);
        return "showCustomers";
    }

    @RequestMapping(value = "/registerAgency", method = RequestMethod.POST)
    public String registrationAgancyDone(@ModelAttribute Agency agency, Model model) {
        System.out.println("Name of agency" + agency.getName());
        System.out.println("Name of agency" + agency.getPhone());
        System.out.println("Name of agency" + agency.getId());
        System.out.println("Name of agency" + agency.getAddress());
        agencyDAO.insert(agency);

        model.addAttribute("name", agency.getName());
        return "agency";
    }

    @GetMapping("/registerEmployee")
    public String registerEmployee(Model model) {
        return "registrationAgency";
    }

    @RequestMapping(value = "/registerEmployee", method = RequestMethod.POST)
    public String registrationEmployeeDone(@ModelAttribute Employee employee, Model model) {
        System.out.println("Name of agency" + employee.getName());
        System.out.println("Name of agency" + employee.getPhone());
        employeeDAO.insert(employee);

        model.addAttribute("name", employee.getName());
        return "employee";
    }


    @GetMapping("/registerCustomer")
    public String registerCustomer(Model model) {
        return "registrationAgency";
    }

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public String registrationCustomerDone(@ModelAttribute Customer customer, Model model) {
        System.out.println("Name of agency" + customer.getName());
        System.out.println("Name of agency" + customer.getPhone());
        customerDAO.insert(customer);
        model.addAttribute("name", customer.getName());
        return "customer";
    }

    @GetMapping("/registerBuyer")
    public String registerBuyer(Model model) {
        return "registrationBuyer";
    }

    @RequestMapping(value = "/registerBuyer", method = RequestMethod.POST)
    public String registrationBuyerDone(@ModelAttribute Buyer buyer, Model model) {
        System.out.println("Name of agency" + buyer.getName());
        System.out.println("Name of agency" + buyer.getPhone());
        buyerDAO.insert(buyer);
        model.addAttribute("name", buyer.getPhone());
        return "buyer";
    }

    @GetMapping("/registerSeller")
    public String registerSeller(Model model) {
        return "registrationSeller";
    }

    @RequestMapping(value = "/registerSeller", method = RequestMethod.POST)
    public String registrationSellerDone(@ModelAttribute Seller seller, Model model) {
        System.out.println("Seller Phone" + seller.getPhone());
        sellerDAO.insert(seller);
        model.addAttribute("name", seller.getPhone());
        return "seller";
    }

    @GetMapping("/registerProperty")
    public String registerProperty(Model model) {
        return "registrationProperty";
    }
/*
    @RequestMapping(value = "/registerSeller", method = RequestMethod.POST)
    public String registrationSellerDone(@ModelAttribute Seller seller, Model model) {
        System.out.println("Seller Phone" + seller.getPhone());
        sellerDAO.insert(seller);
        model.addAttribute("name", seller.getPhone());
        return "seller";
    }*/
}
