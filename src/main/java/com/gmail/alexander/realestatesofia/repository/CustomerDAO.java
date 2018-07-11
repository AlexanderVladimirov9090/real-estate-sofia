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


    class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setPhone(rs.getString("phone"));
            customer.setName(rs.getString("name"));
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
        return jdbcTemplate.update("INSERT INTO Customer (ID, NAME, PHONE) " + "VALUES(?, ?, ?)",
                customer.getId(), customer.getName(), customer.getPhone());
    }

    public int update(Customer customer) {
        return jdbcTemplate.update("UPDATE Customer" + "SET name=?, phone=?  " + "WHERE id=?",
                customer.getName(), customer.getPhone(), customer.getId());

    }
}
