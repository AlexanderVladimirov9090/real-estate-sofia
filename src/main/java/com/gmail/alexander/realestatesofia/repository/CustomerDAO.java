package com.gmail.alexander.realestatesofia.repository;

import com.gmail.alexander.realestatesofia.entity.abstracts.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created on 08.07.18.
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
@Repository
public class CustomerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeDAO employeeDAO;

    class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setPhone(rs.getString("phone"));
            customer.setName(rs.getString("name"));
            customer.setEmployee(employeeDAO.findById(rs.getInt("id")));
            return customer;
        }
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Customer", new CustomerRowMapper());
    }

    public Customer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Customer WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Customer WHERE id=?", id);
    }

    public int insert(Customer customer) {

        return jdbcTemplate.update("INSERT INTO Seller (ID, NAME, PHONE, REAL_ESTATE_EMPLOYEE_ID) " + "VALUES(?, ?, ?, (SELECT id FROM REAL_ESTATE_EMPLOYEE WHERE id=? ))",
                customer.getId(), customer.getName(), customer.getPhone(), randomEmployee(customer.getEmployee().getId()));
    }

    public int update(Customer customer) {
        return jdbcTemplate.update("UPDATE Seller" + "SET name=?, phone=?, REAL_ESTATE_EMPLOYEE_ID=?  " + "WHERE id=?",
                customer.getName(), customer.getPhone(), customer.getEmployee().getId(), customer.getId());

    }

    //TODO extract method.
    private int randomEmployee(int countOfEmployees) {
        Random r = new Random();
        return r.nextInt((countOfEmployees - 1) + 1) + 1;
    }
}
