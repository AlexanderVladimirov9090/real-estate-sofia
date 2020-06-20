package com.gmail.alexander.realestatestore.repository;

import com.gmail.alexander.realestatestore.models.abstracts.Customer;
import com.gmail.alexander.realestatestore.models.concrete.Agency;
import com.gmail.alexander.realestatestore.repository.rowmappers.CustomerRowMapper;
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

    /**
     * Finds all Records of Customer
     *
     * @return
     */
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Customer", new CustomerRowMapper());
    }

    /**
     * Finds single record by id
     *
     * @param id given id for the fetching of data.
     * @return
     */
    public Customer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Customer WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public Customer findTopByOrderByIdDesc() {
        return jdbcTemplate.queryForObject("SELECT * FROM Customer ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    /**
     * Deletes Record for the database
     *
     * @param id for deletion
     * @return
     */
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Customer WHERE id=?", id);
    }

    /**
     * This is used to insert record to the database.
     *
     * @param customer
     * @return
     */
    public int insert(Customer customer) {
        return jdbcTemplate.update("INSERT INTO Customer ( NAME, PHONE) " + "VALUES( ?, ?)", customer.getName(), customer.getPhone());
    }


    /**
     * Updates record from database by id.
     *
     * @param customer updated version of the record.
     * @return confirmation code.
     */
    public int update(Customer customer) {
        return jdbcTemplate.update("UPDATE Customer" + "SET name=?, phone=?  " + "WHERE id=?", customer.getName(), customer.getPhone(), customer.getId());
    }
}
